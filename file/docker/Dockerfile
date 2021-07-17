FROM java:8
COPY *.jar /BootDemo.jar
CMD ["--server.port=80"]
EXPOSE 80
VOLUME /run/log/
ENTRYPOINT ["java","-jar","/BootDemo.jar"]