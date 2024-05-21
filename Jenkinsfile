pipeline{
  agent any
  stages{

    stage('clone'){
      steps{
        git 'https://github.com/Cristian221097/PicheoAutomatizacion.git'
      }
    }
    
    stage('Build'){
      steps{
        sh 'mvn clean compile'
      }
    }
    stage('Test'){
      steps{
      sh 'mvn test'
      }
    }
  }
}
