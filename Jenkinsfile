pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3.9.6'
        JAVA_HOME = tool 'JDK17'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
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
                sh 'pkill -f "org.springframework.boot.loader.JarLauncher" || true'
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
