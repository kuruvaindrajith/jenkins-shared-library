def call() {
    stage('Build') {
        echo 'Building the application...'
        sh 'docker build -t myapp:latest .'
    }
    stage('Test') {
        echo 'Testing the application...'
        sh 'docker run --rm myapp:latest'
    }
    stage('Deploy') {
        echo 'Deploying the application...'
        sh 'kubectl apply -f deployment.yaml'
    }
}
