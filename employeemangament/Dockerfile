FROM java:8
# Add a volume pointing to /tmp
# VOLUME /tmp


# Make port 8080 available to the world outside this container

WORKDIR /usr/src/myapp
ADD /target/employeemangament.jar employeemangament.jar

# Run the jar file
ENTRYPOINT ["java","-jar","employeemangament.jar"]
EXPOSE 8081
 