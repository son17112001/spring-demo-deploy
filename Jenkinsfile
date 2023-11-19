pipeline {
    agent any

    stages {
        stage('Build with Maven') {
            tools {
                maven 'my-maven'
            }
            steps {
                sh 'mvn --version'
                sh 'java -version'
                sh 'mvn clean package -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Deploy Spring Boot to DEV') {
            steps {
                echo 'Deploying and cleaning'
                sh 'docker compose down || echo "No existing containers"'
                sh 'docker compose -f docker-compose.yml build'
                sh 'docker compose -f docker-compose.yml up -d'
                sh 'docker compose up --scale springboot=3'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}