pipeline{
  agent any
  stages{
    stage('Checkout'){
      git ''
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
