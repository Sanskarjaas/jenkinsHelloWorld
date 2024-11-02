pipeline {
    agent any
    tools{
        terraform 'TERRAFORM'
    }

    stages {
        stage('Hello') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Sanskarjaas/TerraformVM.git']])
            }
        }
        stage("terraform version")
        {
            steps{
                bat "terraform -version"
            }
        }
        stage("terraform init")
        {
            steps{
                bat "terraform init"
            }
        }
         stage("terraform plan")
        {
            steps{
                bat "terraform plan"
            }
        }
    }
}
