pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "mahmoud", 
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
                bat "mvn clean install deploy:deploy-file -DskipTests  -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=4.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-4.0.jar"
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
