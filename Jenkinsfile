pipeline {

    agent any


    stages {
        stage ('Git') {
            steps {
               echo "Getting Project from Git"; 
		git branch : 'main',
               url: 'https://github.com/bahagh/tpAchatProject.git', 
		credentialsId: 'tpachat';
           }
        }
	
	stage("Build") {
            steps {
                sh "mvn clean package"
                
            }
        }

	stage("Unit Testing") {
            steps {
                echo "NOT_YET lancer les Tests unitaire avec JUnit et Mockito."
            }
        }

	stage("SRC Analysis Testing") {
            steps {
                echo "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=root"
            }
        }
	
        stage("Build Docker image") {
            steps {
                sh "docker build -t bahagh/projetdevops . "
            }
        }
	
        stage('Deploy Artifact to Nexus') {
             steps {
		echo "nehsbou rwehna aamlana e nexus"
	}
        }

        stage("Deploy Dokcer Image to DockerHub(private registry)") {
            steps {
	    	echo "docker login -u username -p pw"
                
            }
        }
	
	stage("Start Containers") {
            steps {
                echo "NOT8YET lancer l'application TpAchat et la base de données."
		sh "docker-compose up -d"
            }
        }	
      
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
