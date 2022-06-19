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
         stage("build package"){
            steps{
                withMaven {
                    sh 'mvn clean package -DskipTests'
                 } 
            }
          
        }
    }
  
}