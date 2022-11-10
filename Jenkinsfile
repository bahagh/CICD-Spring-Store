pipeline {

    agent any


    stages {
         stage ('GIT Checkout') {
            steps {
               echo "Getting Project from Git";
                git branch: "main",
                    url: "https://github.com/bahagh/tpAchatProject.git";
                    
            }
        }
	
	}
}
