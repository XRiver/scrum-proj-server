pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
	    stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube analyze') {
            steps {
                sh 'mvn sonar:sonar \
  -Dsonar.projectKey=XRiver_scrum-proj-server \
  -Dsonar.organization=xriver-github \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=07979a1e408cd6fdc91073a17604e4b02bb54f9b \
  -Dsonar.java.binaries=Jenkins/out'
            }
        }
    }
}
