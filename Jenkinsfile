pipeline{
  agent any
  stages{

    stage('Check permissions'){
      steps{
        sh 'whoami'
        sh 'pwd'
        sh 'ls -l C:\ProgramData\Jenkins\.jenkins\workspace'
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
