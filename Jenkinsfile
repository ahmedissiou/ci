pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "farah", 
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
		
		stage ("Email Notification") {
            steps {
                mail bcc: '', body: '''Hi Farah,

                        Your last pipeline build is complete!

                        Regards.

                        NOTE: Please do not reply to this email.''', cc: '', from: '', replyTo: '', subject: 'Jenkins Pipeline', to: 'farahayari7262@gmail.com'   
            
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=2.6 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-2.6.jar"
            }
        }
    
    
    stage("Publish Test Coverage Report") {
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
