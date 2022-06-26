pipeline{
    agent any
      environment {
        VERSION = "${env.BUILD_ID}"
    }
    stages{
        stage("Test"){
            steps{
                withMaven {
                    sh 'mvn  test'
                 } 
            }
          
        }
        stage("Sonar code analysis"){
            steps{
               script{ 
                 withSonarQubeEnv(credentialsId: 'sonar-token') {
                     sh 'chmod +x mvnw'
                     sh './mvnw sonar:sonar -Dsonar.host.url=http://34.134.86.59:9000 -Dsonar.login=f5f186e6b3c2cad9a4535bc5ea2798d8e21bd51d'
                 }
                        timeout(time: 15, unit: 'MINUTES') {
                      def qg = waitForQualityGate()
                      if (qg.status != 'OK') {
                           error "Pipeline aborted due to quality gate failure: ${qg.status}"
                      }
                   } 
               } 
            }
        }
         stage("build package"){
            steps{
                withMaven {
                    sh 'mvn clean package -DskipTests'
                 } 
            }
          
        }
        stage("Docker build and push"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'docker_pass', variable: 'docker_cred')]) {
                     sh '''
                       docker build -t keoffor/devops-img:${VERSION} . 
                       docker login -u keoffor -p $docker_cred  
                       docker push  keoffor/devops-img:${VERSION}
                       docker rmi keoffor/devops-img:${VERSION}
                    ''' 
                }

                }
            }
        }
      stage("Deploy to GKE"){
        steps{
            script{
                
                   withCredentials([kubeconfigFile(credentialsId: 'kube-gke', variable: 'KUBECONFIG')]) {
                    dir('Kubernetes/') {
                         sh 'helm list'
                    
                     }
                    }
                }
        }
      }   
    }
  
}