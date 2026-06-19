def call(String region = 'eu-north-1') {

    withCredentials([
        usernamePassword(
            credentialsId: 'AWS-Keys',
            usernameVariable: 'AWS_ACCESS_KEY_ID',
            passwordVariable: 'AWS_SECRET_ACCESS_KEY'
        )
    ]) {

        sh """
            export AWS_ACCESS_KEY_ID=\$AWS_ACCESS_KEY_ID
            export AWS_SECRET_ACCESS_KEY=\$AWS_SECRET_ACCESS_KEY
            export AWS_DEFAULT_REGION=${region}

            aws sts get-caller-identity
        """
    }
}
