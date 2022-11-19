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

        stage("Running Tests")
        {
            steps{
                sh 'mvn test'
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
       
       
       
      
        
       
        
        stage("Nexus")
        {
            steps{
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: '192.168.224.187:8081',
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: 'maven-releases',
                            credentialsId: 'deploymentRepo2',
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
            }}}
        }
        
   
        
        stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":latest"

                }

            } 

        }
        
        stage('Deploying our image') { 

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
