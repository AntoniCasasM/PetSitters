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

			
	stage('Deliver') { 
            steps {
		 sh 'chmod 777 ./jenkins/release.sh'
                sh './jenkins/release.sh' 
            }
	}
	}
}
