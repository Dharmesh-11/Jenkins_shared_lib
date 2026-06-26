def call() {
    withCredentials([string(credentialsId: 'nvd-key', variable: 'NVD_API_KEY')]) {

        dependencyCheck(
            odcInstallation: 'OWASP',
            additionalArguments: "--scan ./ --nvdApiKey=${NVD_API_KEY} --nvdApiDelay 5000"
        )

        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
