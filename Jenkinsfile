

pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
      stage('SCM') {
        git 'https://github.com/atomorojo/PetSitters.git'
      }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube analysis') {
            def scannerHome = tool 'SonarQube Scanner 2.8';
            withSonarQubeEnv('Sonarqube') {
              sh "${scannerHome}/bin/sonar-scanner"
            }
          }
    }
}


