pipeline{
 agent any

 stages{

    stage('Build') {
             steps {
                 // Proporciona el archivo settings.xml que apunta al repositorio local .m2
                 echo 'Iniciando settings'
                 configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    bat 'mvn clean install --settings $MAVEN_SETTINGS'
                 }
             }
 }
  stage('Ejecucion'){
    steps{
        echo 'start'
        bat 'mvn test'
    }

  }


 }

}