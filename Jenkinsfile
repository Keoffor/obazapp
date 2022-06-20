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
                     sh ''
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