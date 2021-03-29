FROM openjdk:8
EXPOSE 8080
ADD target/jenkins-docker-kubernetes-deploy.jar jenkins-docker-kubernetes-deploy.jar
ENTRYPOINT ["java","-jar","/jenkins-docker-kubernetes-deploy.jar"]