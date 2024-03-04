// pipeline {
//     agent any
//     environment {
//         AWS_ACCOUNT_ID = "357586184453"
//         AWS_DEFAULT_REGION = "eu-west-1"
//         IMAGE_REPO_NAME = "learnspace-repo-for-systest"
//         IMAGE_TAG = "v1"
//         REPOSITORY_URI = "357586184453.dkr.ecr.eu-west-1.amazonaws.com/learnspace-repo-for-systest"
//         CLUSTER = "learnspace"

//         SERVICE = "learnspacesystestjenkins"

//     }
   
//     stages {
//         stage('Logging into AWS ECR') {
//             steps {
//                 script {
//                     sh """aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"""
//                 }
//             }
//         }
        
//         // Building Docker images
//         stage('Building image') {
//             steps {
//                 script {
//                     echo "Building Docker image..."
//                     sh "docker build -t ${IMAGE_REPO_NAME}:${IMAGE_TAG} --no-cache ."
//                 }
//             }
//         }
   
//         // Uploading Docker images into AWS ECR
//         stage('Pushing to ECR') {
//             steps {
//                 script {
//                     sh "docker tag ${IMAGE_REPO_NAME}:${IMAGE_TAG} ${REPOSITORY_URI}:${IMAGE_TAG}"
//                     sh "docker push ${REPOSITORY_URI}:${IMAGE_TAG}"
//                 }
//             }
//         }

//         stage('Deploy to ECS') {
//             steps {
//                 script {
//                     sh "aws ecs update-service --cluster ${CLUSTER} --service ${SERVICE} --force-new-deployment"
//                 }
//             }
//         }
//     }
// }
