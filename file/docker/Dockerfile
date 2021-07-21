FROM java:8
COPY *.jar /BootDemo.jar
CMD ["--server.port=8090"]
EXPOSE 8090
VOLUME /run/log/
ENTRYPOINT ["java","-jar","/BootDemo.jar"]