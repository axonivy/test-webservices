pipeline {
  agent {
    docker {
      image 'maven:3.5.2-jdk-8'
    }
  }
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
          maven cmd: '-f country-service/pom.xml install'
		  maven cmd: '-f test-rest-service/pom.xml install'
        }
      }
    }
    stage('deploy') {
      steps {
        script {
          maven cmd: '-f country-service/pom.xml tomcat7:redeploy'
		  maven cmd: '-f test-rest-service/pom.xml tomcat7:redeploy'
        }
      }
    }
  }
}
