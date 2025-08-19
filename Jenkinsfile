pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // your build steps here
            }
        }
    }

    post {
        success {
            withCredentials([string(credentialsId: 'TELEGRAM_BOT_TOKEN', variable: 'TOKEN')]) {
                sh """
                curl -s -X POST https://api.telegram.org/bot$TOKEN/sendMessage \
                -d chat_id=-1002921935948 \
                -d text="✅ Build Success: Job $JOB_NAME Build #$BUILD_NUMBER"
                """
            }
        }
        failure {
            withCredentials([string(credentialsId: 'TELEGRAM_BOT_TOKEN', variable: 'TOKEN')]) {
                sh """
                curl -s -X POST https://api.telegram.org/bot$TOKEN/sendMessage \
                -d chat_id=-1002921935948 \
                -d text="❌ Build Failed: Job $JOB_NAME Build #$BUILD_NUMBER"
                """
            }
        }
    }
}
