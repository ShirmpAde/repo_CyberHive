# alpine linux included openjdk 21
FROM openjdk:21-jdk

# project directory
ENV project="cyberhive"

# set timezone
# RUN apk add tzdata && ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

# create project directory
RUN mkdir ${project}

#COPY build/libs/*.jar /${workdir}/spring-base.jar
COPY build/libs/*.jar /${project}/${project}.jar

# exec jar without env
ENTRYPOINT ["sh", "-c", "java -jar /${project}/${project}.jar"]