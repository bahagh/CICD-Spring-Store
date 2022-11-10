pipeline {

    agent any


    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git";
                git branch: "main",
                    url: "https://github.com/bahagh/tpAchatProject.gitr",
                    credentialsId: "first pipeline";
            }
        }
       
        stage("Build") {
            steps {
                sh "mvn -version"
                bat "mvn clean package -DskipTests"
            }
        }

        
   }
    post {
        always {
            cleanWs()
        }
    }
    
}
