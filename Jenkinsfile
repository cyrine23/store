pipeline {
    agent any
environment {
        registry = "cyrine27/storewithspring"
        registryCredential = 'dockerHub'
        dockerImage = ''
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.154:8081"
        NEXUS_REPOSITORY = "maven-releases"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
    }

       stages{
           
        stage('MVN CLEAN') {
            steps {
                sh "mvn clean"
            }
        }
        stage('MVN COMPILE') {
            steps {
                sh "mvn compile"
            }
        }
        stage('MVN PACKAGE') {
         steps {
                sh "mvn package -DskipTests"
              }
          }
        stage('MVN TEST') {
            steps {
                sh "mvn test"
            }
        }
        stage('NEXUS')
                                                              {
                                                                  steps{
                                                                      echo "nexus"
                                                                       sh ' mvn clean deploy -DskipTests'
                                                                  }
                                                              }
  stage('Maven SONARQUBE') {
            steps {
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
            }
        }

        stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
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
        stage('DOCKER COMPOSE') {
             steps {
                sh 'docker-compose up -d '
            } 
        }
   }

       post {
          success {
                         mail to: "sirine.fatnassi.27@gmail.com",
                         subject: "Pipeline Success",
                         body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
                     }
                     failure {
                         mail to: "sirine.fatnassi.27@gmail.com",
                         subject: "Pipeline Failure",
                         body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "
                     }
     }

}
