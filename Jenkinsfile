pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '5'))
  }

  triggers {
    cron '@daily'
  }

  stages {
    stage('build') {
      steps {
        script {
          docker.withRegistry('https://registry.ivyteam.io', 'registry.ivyteam.io') {
            docker.build("axonivy/test-webservices:latest").push()
          }
        }
      }
    }
  }
}
