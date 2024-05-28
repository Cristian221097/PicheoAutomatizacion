pipeline{
  agent any
  stages{

    stage('Check permissions'){
      steps{
        sh 'whoami'
        sh 'ls -l C:\ProgramData\Jenkins\.jenkins\workspace\PicheoToday\src\main\resources\picheo'
        sh 'C:\ProgramData\Jenkins\.jenkins\workspace\PicheoToday\src\main\resources\picheo'
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
