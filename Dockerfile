FROM eclipse-temurin:25-jre-alpine
COPY target/classes/com/example/socket/SimpleServer.class /app/com/example/socket/SimpleServer.class
ENTRYPOINT ["java", "-classpath", "/app", "com.example.socket.SimpleServer"]