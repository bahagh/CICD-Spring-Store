pipeline {

    agent any


    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "main", 
                    url: "https://github.com/bahagh/tpAchatProject.git",
		    credentialsId: "tpachat";
            }
        }
       
        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean package"
            }
        }

        stage("Sonar") {
            steps {
                sh "mvn sonar:sonar"
            }
        }
        
        stage("SRC Analysis Testing") {
            steps {
                sh "mvn sonar:sonar"
            }
        }
        
        stage("Build Docker image") {
            steps {
                sh "..............."
            }
        }

        stage("Deploy Artifact to private registry") {
            steps {
                sh "..............."
            }
        }

        stage("Deploy Dokcer Image to private registry") {
            steps {
                sh "..............."
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
