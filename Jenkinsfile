pipeline {
    agent any

    stages {
        stage('Building') {
            steps {
                echo 'Building the dev project'
            }
        }
 	stage('Testing') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'e4b1c562-4f24-4b82-a354-9bede2b22ec3',url: 'https://github.com/autismhitman/sImplement.git']])
               bat 'mvn clean test'
            }
        }
       
         stage('Deploy') {
            steps {
                echo 'Depoying the code on staging server'
            }
        }
    }
}
