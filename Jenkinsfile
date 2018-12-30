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
                sh 'mvn sonar:sonar -Dsonar.projectKey=XRiver_scrum-proj-server -Dsonar.organization=xriver-github  -Dsonar.host.url=https://sonarcloud.io  -Dsonar.login=d474fa7fd1c788dc17e93549ff62f9606546c001'
            }
        }
    }
}