pipeline {
  agent {
    docker {
      image 'maven:3.5.2-jdk-8'
    }
  }
  triggers {
    pollSCM '@hourly'
  }
  stages {
    stage('build') {
      steps {
        script {
          maven cmd: '-f country-service/pom.xml install'
        }
      }
    }
  }
}
