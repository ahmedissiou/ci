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
            }
        }
        //hello
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        stage("Email Notification") {
            steps {
              mail bcc: '', body: 'Bonjour , pipeline est en cours d\'execution ', cc: '', from: '', replyTo: '', subject: 'Jenkins', to: 'ahmed.issiou@esprit.tn'
            }
        }
        
        stage("DEPLOY") {
            steps {
				
                bat "mvn clean install deploy:deploy-file -DskipTests  -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=9.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-9.0.jar"
            }
        }
        stage('Publish Test Coverage Report') {
         steps {
           step([$class: 'JacocoPublisher', 
                execPattern: '*/build/jacoco/.exec',
                classPattern: '**/build/classes',
                sourcePattern: 'src/main/java',
                exclusionPattern: 'src/test*'
                ])
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
