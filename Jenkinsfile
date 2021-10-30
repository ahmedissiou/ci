pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "main", 
                    url: "https://github.com/ahmedissiou/ci.git",
                    credentialsId: "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"; 
            }
        }

        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package -DskipTests"
                // sh "mvn clean package -DskipTests" pour une machine linux
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn deploy -DskipTests"
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
