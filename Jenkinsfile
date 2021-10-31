pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "ahmed", 
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
				
                bat "mvn clean install deploy:deploy-file -DskipTests  -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=5.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-5.0.jar"
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
