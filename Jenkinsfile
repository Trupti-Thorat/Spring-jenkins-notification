post {
    always {
        echo "Build result: ${currentBuild.currentResult}"
    }
    success {
        echo "Sending success message to Telegram..."
        withCredentials([string(credentialsId: 'telegram-bot-token', variable: 'TOKEN')]) {
            sh 'echo "Using TOKEN=$TOKEN"'
            sh '''
            curl -v -X POST https://api.telegram.org/bot$TOKEN/sendMessage \
            -d chat_id=-1002921935948 \
            -d text="✅ Build Success: Job $JOB_NAME Build #$BUILD_NUMBER"
            '''
        }
    }
    failure {
        echo "Sending failure message to Telegram..."
        withCredentials([string(credentialsId: 'telegram-bot-token', variable: 'TOKEN')]) {
            sh '''
            curl -v -X POST https://api.telegram.org/bot$TOKEN/sendMessage \
            -d chat_id=-1002921935948 \
            -d text="❌ Build Failed: Job $JOB_NAME Build #$BUILD_NUMBER"
            '''
        }
    }
}
