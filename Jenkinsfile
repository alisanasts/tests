pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/alisanasts/tests.git'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
