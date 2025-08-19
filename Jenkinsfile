post {
    success {
        withCredentials([string(credentialsId: 'telegram-bot-token', variable: 'TOKEN')]) {
            sh """
                curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage \
                -d chat_id=-1002921935948 \
                -d text='✅ Build Success: Job spring-jenkins Build #${BUILD_NUMBER}'
            """
        }
    }
    failure {
        withCredentials([string(credentialsId: 'telegram-bot-token', variable: 'TOKEN')]) {
            sh """
                curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage \
                -d chat_id=-1002921935948 \
                -d text='❌ Build Failed: Job spring-jenkins Build #${BUILD_NUMBER}'
            """
        }
    }
}
