pipeline{
  agent any
  stages{

    stage('Check permissions'){
      steps{
        script{
        sh 'whoami'
        sh 'pwd'
          sh 'ls -l'
        }
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
