pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3.9.6' // Update to your Maven tool name in Jenkins
        JAVA_HOME = tool 'JDK17'        // Update to your JDK tool name in Jenkins
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/kavinnath-22CSR094/LibraryManagementSystem' // Replace with your repo URL
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Run Application') {
            steps {
                // Optional: Stop previous instance
                sh 'pkill -f "org.springframework.boot.loader.JarLauncher" || true'

                // Start application in background
                sh 'nohup mvn spring-boot:run &'
            }
        }
    }

    post {
        success {
            echo 'Library Management System built and deployed successfully!'
        }
        failure {
            echo 'Build failed! Check logs.'
        }
    }
}
