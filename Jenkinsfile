pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo '🔨 Building Spring Boot app...'
                bat './mvnw clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                bat './mvnw test'
            }
        }
    }

    post {
        success {
            script {
                def message = "✅ Build SUCCESS for project: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
                bat """
                  curl -s -X POST https://api.telegram.org/bot8322680324:AAEQSKGCwSIBXCfCObAG7FYbLCRaEyYU9MQ/sendMessage ^
                  -d chat_id=6739307757 ^
                  -d text="${message}"
                """
            }
        }
        failure {
            script {
                def message = "❌ Build FAILED for project: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
                bat """
                  curl -s -X POST https://api.telegram.org/bot8322680324:AAEQSKGCwSIBXCfCObAG7FYbLCRaEyYU9MQ/sendMessage ^
                  -d chat_id=6739307757 ^
                  -d text="${message}"
                """
            }
        }
    }
}
