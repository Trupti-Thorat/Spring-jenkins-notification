pipeline {
    agent any   // run on any available Jenkins agent

    stages {
        stage('Build') {
            steps {
                echo '🔨 Building Spring Boot app...'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                sh './mvnw test'
            }
        }
    }

    post {
        success {
            script {
                def message = "✅ Build SUCCESS for project: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
                sh """
                  curl -s -X POST https://api.telegram.org/bot8322680324:AAEQSKGCwSIBXCfCObAG7FYbLCRaEyYU9MQ/sendMessage \
                  -d chat_id=6739307757 \
                  -d text="${message}"
                """
            }
        }
        failure {
            script {
                def message = "❌ Build FAILED for project: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
                sh """
                  curl -s -X POST https://api.telegram.org/bot8322680324:AAEQSKGCwSIBXCfCObAG7FYbLCRaEyYU9MQ/sendMessage \
                  -d chat_id=6739307757 \
                  -d text="${message}"
                """
            }
        }
    }
}
