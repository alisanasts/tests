pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/alisanasts/tests.git'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
