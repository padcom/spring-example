pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -f spring-web/pom.xml -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'spring-web/target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
