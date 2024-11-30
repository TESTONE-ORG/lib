// vars/examplePipeline.groovy

def call(String name = 'World') {
    pipeline {
        agent any
        stages {
            stage('Greeting') {
                steps {
                    echo "Hello, ${name}!"
                }
            }
        }
    }
}
