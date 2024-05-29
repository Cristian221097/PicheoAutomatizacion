pipeline {
    agent any
    stages {
        stage('Check permissions') {
            steps {
                script {
                    echo 'Checking user and directory'
                    // Verificar el usuario
                    sh 'whoami'
                    // Imprimir el directorio de trabajo actual
                    sh 'pwd'
                    // Listar los archivos en el directorio de trabajo
                    sh 'ls -l'
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Starting Build Stage'
                script {
                    try {
                        // Ejecutar el comando de Maven
                        sh 'mvn clean compile'
                    } catch (Exception e) {
                        echo "Build failed: ${e.getMessage()}"
                        throw e
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Starting Test Stage'
                script {
                    try {
                        // Ejecutar las pruebas
                        sh 'mvn test'
                    } catch (Exception e) {
                        echo "Test failed: ${e.getMessage()}"
                        throw e
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
