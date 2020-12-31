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
          buildImage("test-webservices-tomcat:latest", "test-webservices-tomcat");
          buildImage("test-webservices-static:latest", "test-webservices-static");
          buildImage("test-webservices-mocks:latest", "test-webservices-mocks");          
        }
      }
    }
  }
}

def buildImage(def name, def contextDir) {
  def image = docker.build(name, contextDir);  
  docker.withRegistry('https://docker-registry.ivyteam.io', 'docker-registry.ivyteam.io') {
    image.push()    
  }
}
