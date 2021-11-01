pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "selim", 
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
		bat "mvn install"		
                bat "mvn clean install deploy:deploy-file -DskipTests  -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=6.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-6.0.jar"
            }
        }
        stage("Email Notification"){
		 steps{
		mail bcc: '', body: '''Hi, this is a jenkins email alert.
        Thanks
        selim.
        cdt''', cc: '', from: '', replyTo: '', subject: 'Jenkins job email Notification', to: 'selimaouini1@gmail.com'	 
		 }
	    }
	    
	    stage ("JaCoCo"){
	       steps{
	       junit '**/target/surefire-reports/TEST-*.xml'
           archive 'target/*.jar'
           step( [ $class: 'JacocoPublisher' ] )
	       
	       
	       }
	    
	    }
    
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
