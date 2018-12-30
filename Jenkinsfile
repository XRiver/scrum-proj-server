pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
	    stage('TestAndDeploy') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
                success {
                    sh 'chmod a+x ./Jenkins/deploy.sh'
                    BUILD_ID=do_not_kill_me
                    JENKINS_NODE_COOKIE=do_not_kill_me
                    sh './Jenkins/deploy.sh'
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
