def buildapp(){
    sh 'npm install'
}

def buildimage(){
    withCredentials([usernamePassword(credentialsId:'docker_credentials',usernameVariable:'USER',passwordVariable:'PWD')]){
      sh "echo $PWD | docker login -u $USER --password-stdin "
      sh 'docker build -t omarsalah123/learningrepo:v1.0 .'
      sh 'docker push omarsalah123/learningrepo:v1.0'
    }
}
def testingapp(){
    sh 'npm test'
}

def deployingapp(){
     sh 'docker-compose up -d'
}
 return this
