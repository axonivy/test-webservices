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
            docker.build("test-webservices-tomcat:latest", "test-webservices-tomcat").push()
            docker.build("test-webservices-static:latest", "test-webservices-static").push()
            docker.build("test-webservices-mocks:latest", "test-webservices-mocks").push()
          }
        }
      }
    }
  }
}
