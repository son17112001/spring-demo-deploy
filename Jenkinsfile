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
                         script {
                               // Thêm đường dẫn của docker-compose vào biến môi trường PATH
                               def dockerComposeHome = tool 'Docker-Compose'
                               withEnv(["PATH+DOCKER_COMPOSE=${dockerComposeHome}/bin"]) {
                                   sh 'echo $PATH' // Kiểm tra xem đường dẫn đã được thêm chưa
                                   sh 'docker-compose -f docker-compose.yml build'
                                   sh 'docker-compose -f docker-compose.yml up -d'
                               }
                           }
                       }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}