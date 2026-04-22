pipeline {
    agent any

    environment {
        APP_NAME = "invent-artificial"
        IMAGE_NAME = "invent-artificial-image"
        CONTAINER_NAME = "invent-artificial-container"
    }

    tools {
        maven 'Maven'
        jdk 'Java21'
    }

    stages {

        stage('Clone GitHub Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/fullstacktraning/invent_artificial.git'
            }
        }

        stage('Build Spring Boot App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Stop Existing Container') {
            steps {
                sh 'docker stop $CONTAINER_NAME || true'
                sh 'docker rm $CONTAINER_NAME || true'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh '''
                docker run -d \
                --name $CONTAINER_NAME \
                -p 9999:9999 \
                $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment Success'
        }

        failure {
            echo 'Deployment Failed'
        }
    }
}