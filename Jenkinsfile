pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2_HOME"
    }
    
    environment { 

       registry = "yassin3/devops_project"
       dockerImage = '' 

    }

    stages {
        stage('Git') {
            steps {
              echo 'Pulling from git ..';
                git branch: 'YASSINE', url: 'https://github.com/majd02/Devops.5SAE2.git';

               
            }

        }
       
        stage('Testing maven') {
            steps{
                sh 'mvn -version'
            }
        }
       
        stage('Clean') {
            steps{
                sh """mvn clean"""
            }
        }
       
        stage('Compile') {
            steps{
                sh """mvn compiler:compile"""
            }
        }
       
       
       
      stage(" SonarQube") {
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        stage("Running Tests")
        {
            steps{
                sh 'mvn test'
            }
        }
       
        
        stage("Nexus")
        {
            steps{
                sh 'mvn deploy -DskipTests'
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

                    docker.withRegistry( '', "dockerhub_devops") { 

                        dockerImage.push() 

                    }

                } 

            }

        } 
        
        stage('docker composer') { 

            steps { 

                sh "docker-compose up -d" 

            }

        }
   
        
    }
}
