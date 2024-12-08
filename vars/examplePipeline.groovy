def call(Map config = [:]) {
    stage('Build') {
        echo "Building project: ${config.projectName}"
    }
    stage('Test') {
        echo "Running tests for project: ${config.projectName} in environment: ${config.environment}"
    }
    stage('Deploy') {
        echo "Deploying project: ${config.projectName} to environment: ${config.environment}"
    }
}
