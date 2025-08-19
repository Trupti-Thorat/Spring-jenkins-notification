pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo "Building the project..."
                // your build commands go here
            }
        }
        stage('Test') {
            steps {
                echo "Running tests..."
                // your test commands go here
            }
        }
    }

    post {
        success {
            script {
                def BOT_TOKEN = "8322680324:AAEQSKGCwSIBXCfCObAG7FYbLCRaEyYU9MQ"
                def CHAT_ID = "-1002921935948"
                def MESSAGE = "✅ Build SUCCESS for job: ${env.JOB_NAME} (#${env.BUILD_NUMBER})"
                sh """
                   curl -s -X POST https://api.telegram.org/bot${BOT_TOKEN}/sendMessage \
                   -d chat_id=${CHAT_ID} \
                   -d text="${MESSAGE}"
                """
            }
        }
        failure {
            script {
                def BOT_TOKEN = "8322680324:AAEQSKGCwSIBXCfCObAG7FYbLCRaEyYU9MQ"
                def CHAT_ID = "-1002921935948"
                def MESSAGE = "❌ Build FAILED for job: ${env.JOB_NAME} (#${env.BUILD_NUMBER})"
                sh """
                   curl -s -X POST https://api.telegram.org/bot${BOT_TOKEN}/sendMessage \
                   -d chat_id=${CHAT_ID} \
                   -d text="${MESSAGE}"
                """
            }
        }
    }
}
