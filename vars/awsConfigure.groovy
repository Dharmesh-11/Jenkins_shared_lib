def call(String region = 'eu-north-1') {

    withCredentials([
        [$class: 'AmazonWebServicesCredentialsBinding',
         credentialsId: 'AWS-Keys']
    ]) {

        sh """
            export AWS_DEFAULT_REGION=${region}

            aws sts get-caller-identity
        """
    }
}
