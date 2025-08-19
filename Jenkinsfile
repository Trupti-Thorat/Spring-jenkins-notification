pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Add your build steps here
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test steps here
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy steps here
            }
        }
    }

    post {
        always {
            echo "Pipeline finished"
        }
        success {
            echo "✅ Build successful!"
            withCredentials([string(credentialsId: 'telegram-bot-token', variable: 'TOKEN')]) {
                sh """
                curl -s -X POST https://api.telegram.org/bot$TOKEN/sendMessage \
                    -d chat_id=-1002921935948 \
                    -d text="✅ Jenkins build SUCCESS on job: ${JOB_NAME} [#${BUILD_NUMBER}]"
                """
            }
        }
        failure {
            echo "❌ Build failed!"
            withCredentials([string(credentialsId: 'telegram-bot-token', variable: 'TOKEN')]) {
                sh """
                curl -s -X POST https://api.telegram.org/bot$TOKEN/sendMessage \
                    -d chat_id=-1002921935948 \
                    -d text="❌ Jenkins build FAILED on job: ${JOB_NAME} [#${BUILD_NUMBER}]"
                """
            }
        }
    }
}
