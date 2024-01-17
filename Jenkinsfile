pipeline {
    agent any
    environment {
        registry = "bahagh/achat"
        registryCredential = 'devops'
        dockerImage = ''
    }

    stages {
        stage('GIT CHECKOUT') {
            steps {
                git branch: 'operateur', url: 'https://github.com/bahagh/tpAchatProject.git',
                credentialsId: "git_token";
            }
        }
         stage('CLEAN PCKG') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
         stage('SRC ANALYSIS TESTING ( SONARQUBE )') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
          stage('UNIT TESTING ( JUINT/MOCKITO )') {
            steps {
                sh 'mvn test'
            }
        }
         stage('DEPLOYING ARTIFACT TO NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }
        stage('BUILDING DOCKER IMAGE') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        
          stage('DEPLOYING DOCKER IMAGE ( DOCKERHUB ) ') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
