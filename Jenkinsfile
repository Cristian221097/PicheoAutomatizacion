pipeline{
 agent any

 environment{
    MAVEN_OPTS = "-s C:\\Users\\DELL\\.m2\\settings.xml"
 }

 stages{

  stage('Ejecucion'){
    steps{
        echo 'start'
        bat 'mvn test'
    }

  }


 }

}