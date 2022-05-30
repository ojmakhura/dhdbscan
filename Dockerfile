# Dockerfile
FROM openjdk:11

RUN apt-get update
RUN apt-get install wget 
RUN apt-get install libgomp1
RUN wget https://github.com/ojmakhura/hdbscan/releases/download/v5.1.2/hdbscan-jar_5.1.2_amd64.deb
RUN wget https://github.com/ojmakhura/hdbscan/releases/download/v5.1.2/hdbscan-java_5.1.2_amd64.deb
RUN wget https://github.com/ojmakhura/hdbscan/releases/download/v5.1.2/hdbscan-lib_5.1.2_amd64.deb
RUN wget https://github.com/ojmakhura/hdbscan/releases/download/v5.1.2/hdbscan-python_5.1.2_amd64.deb
RUN apt install ./hdbscan-jar_5.1.2_amd64.deb ./hdbscan-java_5.1.2_amd64.deb ./hdbscan-lib_5.1.2_amd64.deb ./hdbscan-python_5.1.2_amd64.deb

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hdbscan-rest.jar
ENTRYPOINT ["java","-jar","/hdbscan-rest.jar"]