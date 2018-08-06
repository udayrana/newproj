 Start with a base image containing Java runtime
FROM java:8

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 9000

ADD /target/employeemangament.jar employeemangament.jar

# Run the jar file  
ENTRYPOINT ["java","-jar","employeemangament.jar"]    
 