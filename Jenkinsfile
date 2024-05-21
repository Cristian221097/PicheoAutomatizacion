pipeline{
  agent any
  stages{
    stage('Checkout'){
      git 'https://github.com/Cristian221097/PicheoAutomatizacion.git'
    }
    stage('Build'){
      steps{
        sh 'mvn clean compile'
      }
    }
    stage('Test'){
      sh 'mvn test'
    }
  }
}
