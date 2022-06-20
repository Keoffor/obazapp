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
                     sh 'chmod +x mvnw'
                     sh './mvnw sonar:sonar -Dsonar.host.url=http://http://35.193.175.91:9000 -Dsonar.login=f5f186e6b3c2cad9a4535bc5ea2798d8e21bd51d'
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