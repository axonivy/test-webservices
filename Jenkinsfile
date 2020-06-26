pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '5'))
  }

  triggers {
    pollSCM '@hourly'
    cron '@daily'
  }

  stages {
    stage('build') {
      steps {
        script {
          sh 'docker build -t test-webservice .'
        }
      }
    }
  }
}
