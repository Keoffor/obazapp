pipeline{
    agent any
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
                     sh './mvnw sonar:sonar -Dsonar.host.url=http://35.193.175.91:9000 -Dsonar.login=f5f186e6b3c2cad9a4535bc5ea2798d8e21bd51d'
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
    }
  
}