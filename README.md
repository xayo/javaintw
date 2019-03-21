
[![Build Status](https://xayo.visualstudio.com/Java%20DevOps/_apis/build/status/xayo.javaintw?branchName=master)](https://xayo.visualstudio.com/Java%20DevOps/_build/latest?definitionId=12&branchName=master)

# Java, Maven & Jenkins - Azure DevOps pipeline

Java sampple application using Maven 3.0.6 and JUnit 5.  
The project has GitHub to Azure DevOps pipline integration using YAML (pipline as code) CI. The build result success/fail is reporeted to GitHub trough build badge in as part of README.

The pipeline also has option to publish the resulted artifact in private Azure Artifact store.

## Realted Documents
* [Build a Maven package using Jenkins and Azure DevOps](https://docs.microsoft.com/en-us/azure/devops/java/labs/mavenpmjenkins/?view=azure-devops)
* [Configuring a CD pipeline for your Jenkins CI](https://azuredevopslabs.com/labs/vstsextend/jenkins/)
* [Continuously deploy from a Jenkins build](https://docs.microsoft.com/en-us/azure/devops/pipelines/release/integrate-jenkins-pipelines-cicd?view=azure-devops&tabs=yaml)
* [Use Azure Container Instances as a Jenkins build agent](https://docs.microsoft.com/en-us/azure/container-instances/container-instances-jenkins)
* [Create a Jenkins server on an Azure Linux VM from the Azure portal](https://docs.microsoft.com/en-us/azure/jenkins/install-jenkins-solution-template)
* [Release artifacts and artifact sources](https://docs.microsoft.com/en-us/azure/devops/pipelines/release/artifacts?view=azure-devops#jenkinssource)
* [Configuring Builds as Code with YAML in Azure Pipelines](https://azuredevopslabs.com/labs/azuredevops/yaml/)
* [Publish Build Artifacts task](https://docs.microsoft.com/en-us/azure/devops/pipelines/tasks/utility/publish-build-artifacts?view=azure-devops)
* [Publish Test Results task](https://docs.microsoft.com/en-us/azure/devops/pipelines/tasks/test/publish-test-results?view=azure-devops&tabs=yaml)

### Jenkins
* [Build a Java app with Maven](https://jenkins.io/doc/tutorials/build-a-java-app-with-maven/)
* [Pipeline Syntax](https://jenkins.io/doc/book/pipeline/syntax/#agent)
* [Using a Jenkinsfile] https://jenkins.io/doc/book/pipeline/jenkinsfile/
