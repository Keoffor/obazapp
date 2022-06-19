pipeline{
    agent any
    stages{
        stage("Test"){
            steps{
                sh 'echo "Hello world" '
                withMaven {
                    sh "mvn test"
                 } 
            }
          
        }
    }
  
}