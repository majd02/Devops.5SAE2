pipeline {
    environment { 

        registry = "seifderbali/repodock" 

        registryCredential = 'dockerhub_id' 

        dockerImage = '' 

    }
    agent any 
    
    stages {
        stage('GIT') {
          
         steps {
                echo 'cloning project from GIT'
                git branch : "seifderbalibranch" ,
		credentialsId: 'seif' ,
                url :'https://github.com/majd02/Devops.5SAE2.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
               sh 'mvn clean'
            }
        }
        stage('MVN COMPILE') {
            steps {
               sh 'mvn compile'
            
           }
        }
          stage('Scan') {
               steps {
        sh "mvn sonar:sonar \
  -Dsonar.projectKey=Deovps \
  -Dsonar.host.url=http://192.168.1.26:9000 \
  -Dsonar.login=93c3308446195770262249cf7b8ff43a77648d1a"
  echo "sonar succefully"

                      }
                        }
           stage('JUNIT/MOCKITO') {
            steps {
                sh 'mvn test -Dtest="tn.esprit.rh.achat.OperateurServiceTest.java" '            
           }
           
           
        }
                   stage('Nexus Deploy') {
            steps {
               sh 'mvn deploy -DskipTestss'
           }
           
           
        }
         stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":latest" 

                }

            } 

        }

        stage('Deploy our image') { 

            steps { 
                script { 

                    docker.withRegistry( '', registryCredential ) { 

                        dockerImage.push() 

                    }

                } 

            }

        } 

        stage('Cleaning up') { 

            steps { 
                sh "docker rmi $registry:latest" 

            }

        }
        stage(' Docker Compose') { 

            steps { 
                sh "docker-compose up -d" 

            }

        }
        stage('Sending email'){
           steps {
            mail bcc: '', body: '''Jenkins Notification,
            CI Pipeline with success.
            Cordialement''', cc: '', from: '', replyTo: '', subject: 'CI completed ', to: 'seif.derbali@esprit.tn'
            }
       }
        
}
        
    
}