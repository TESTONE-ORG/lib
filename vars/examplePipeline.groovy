def call(Map config = [:]) {
    stage('Build') {
        echo "Building project ${config.projectName}"
    }
    stage('Test') {
        echo "Running tests for ${config.projectName}"
    }
    stage('Deploy') {
        echo "Deploying to ${config.environment}"
    }
}
