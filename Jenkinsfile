pipeline {
	agent {
		docker {
			image 'maven:3-alpine'
			args '-v /root/.m2:/root/.m2'
		}
	}
	stages {

		stage('SCM') {
			steps {
				git 'https://github.com/atomorojo/PetSitters.git'
			}
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
			stage('Deliver') {
				            steps {
                sh './jenkins/scripts/deliver.sh' 
        		    }

			}
			stage('SonarQube analysis') {
				steps {
					withSonarQubeEnv('My SonarQube Server') {
						// requires SonarQube Scanner for Maven 3.2+
						sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
					}
				}
			}
		}
}
