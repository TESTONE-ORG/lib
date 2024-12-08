def call(Map config = [:]) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    echo "Building project ${config.projectName}"
                }
            }
            stage('Test') {
                steps {
                    echo "Running tests for ${config.projectName}"
                }
            }
            stage('Deploy') {
                steps {
                    echo "Deploying to ${config.environment}"
                }
            }
        }
    }
}
