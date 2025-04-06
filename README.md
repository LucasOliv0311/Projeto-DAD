# Projeto-DAD




Documenta��o das Depend�ncias do Projeto
1. Depend�ncias do Spring Boot
* Redis Reativo
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
Fornece integra��o reativa com o Redis usando Spring Data Redis e Project Reactor.
* Web
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
Inclui suporte ao desenvolvimento de APIs REST e aplica��es MVC com Spring Boot.

2. Depend�ncias de Intelig�ncia Artificial
* Neo4j Store
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-neo4j-store-spring-boot-starter</artifactId>
</dependency>
Habilita o uso do Neo4j como um armazenamento para intelig�ncia artificial com Spring AI.
* PostgresML
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-postgresml-spring-boot-starter</artifactId>
</dependency>
Permite a integra��o entre o Spring AI e o PostgreSQL Machine Learning (PostgresML).

3. Depend�ncia para Kafka
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
Facilita a comunica��o ass�ncrona entre servi�os usando Apache Kafka.

4. Depend�ncia para Lombok
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>
Automatiza a gera��o de m�todos boilerplate, como getters e setters, reduzindo c�digo repetitivo.

5. Depend�ncias para Testes
* Spring Boot Test
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
Inclui ferramentas para testes unit�rios e de integra��o no Spring Boot.
* Reactor Test
<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-test</artifactId>
    <scope>test</scope>
</dependency>
Suporte a testes para aplica��es reativas baseadas em Project Reactor.
* Kafka Test
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka-test</artifactId>
    <scope>test</scope>
</dependency>
Oferece ferramentas para testes de integra��o com Kafka.

6. Depend�ncia para JPA
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
Fornece suporte ao Hibernate e JPA para interagir com bancos de dados relacionais.



7. Depend�ncia para PostgreSQL
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
Driver JDBC para conex�o com PostgreSQL.

8. Depend�ncia para JavaFX
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-graphics</artifactId>
    <version>21</version>
</dependency>
Biblioteca para desenvolvimento de interfaces gr�ficas com JavaFX.

9. Depend�ncias para Azure
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-core</artifactId>
    <version>1.54.1</version>
</dependency>
Biblioteca base para integra��o com servi�os da Microsoft Azure.

10. Depend�ncias para Gera��o de Esquema JSON
<dependency>
    <groupId>com.github.victools</groupId>
    <artifactId>jsonschema-module-swagger-2</artifactId>
    <version>4.37.0</version>
</dependency>
Permite a gera��o autom�tica de esquemas JSON baseados no Swagger/OpenAPI.

11. Depend�ncia para Documenta��o da API
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
Gera documenta��o interativa da API baseada no OpenAPI com Swagger UI.



12 . Gerenciamento de Depend�ncias
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-bom</artifactId>
            <version>${spring-ai.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
Garante compatibilidade entre as vers�es das bibliotecas do Spring AI.

13. Plugins do Maven
* Maven Compiler Plugin
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <source>${java.version}</source>
        <target>${java.version}</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
Configura a vers�o do Java e o processamento de anota��es.
* Spring Boot Maven Plugin
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <excludes>
            <exclude>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </exclude>
        </excludes>
    </configuration>
</plugin>
Facilita o empacotamento e execu��o da aplica��o Spring Boot como um JAR independente.

