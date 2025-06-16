# Base image com JDK 17
FROM openjdk:17-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo pom.xml e baixar dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar o código fonte
COPY src ./src

# Compilar o projeto
RUN mvn package -DskipTests

# Porta exposta
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "target/projectFridge-0.0.1-SNAPSHOT.jar"]