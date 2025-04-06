# Projeto-DAD




Documentação das Dependências do Projeto
1. Dependências do Spring Boot
* Redis Reativo
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
Fornece integração reativa com o Redis usando Spring Data Redis e Project Reactor.
* Web
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
Inclui suporte ao desenvolvimento de APIs REST e aplicações MVC com Spring Boot.

2. Dependências de Inteligência Artificial
* Neo4j Store
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-neo4j-store-spring-boot-starter</artifactId>
</dependency>
Habilita o uso do Neo4j como um armazenamento para inteligência artificial com Spring AI.
* PostgresML
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-postgresml-spring-boot-starter</artifactId>
</dependency>
Permite a integração entre o Spring AI e o PostgreSQL Machine Learning (PostgresML).

3. Dependência para Kafka
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
Facilita a comunicação assíncrona entre serviços usando Apache Kafka.

4. Dependência para Lombok
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>
Automatiza a geração de métodos boilerplate, como getters e setters, reduzindo código repetitivo.

5. Dependências para Testes
* Spring Boot Test
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
Inclui ferramentas para testes unitários e de integração no Spring Boot.
* Reactor Test
<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-test</artifactId>
    <scope>test</scope>
</dependency>
Suporte a testes para aplicações reativas baseadas em Project Reactor.
* Kafka Test
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka-test</artifactId>
    <scope>test</scope>
</dependency>
Oferece ferramentas para testes de integração com Kafka.

6. Dependência para JPA
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
Fornece suporte ao Hibernate e JPA para interagir com bancos de dados relacionais.



7. Dependência para PostgreSQL
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
Driver JDBC para conexão com PostgreSQL.

8. Dependência para JavaFX
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-graphics</artifactId>
    <version>21</version>
</dependency>
Biblioteca para desenvolvimento de interfaces gráficas com JavaFX.

9. Dependências para Azure
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-core</artifactId>
    <version>1.54.1</version>
</dependency>
Biblioteca base para integração com serviços da Microsoft Azure.

10. Dependências para Geração de Esquema JSON
<dependency>
    <groupId>com.github.victools</groupId>
    <artifactId>jsonschema-module-swagger-2</artifactId>
    <version>4.37.0</version>
</dependency>
Permite a geração automática de esquemas JSON baseados no Swagger/OpenAPI.

11. Dependência para Documentação da API
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
Gera documentação interativa da API baseada no OpenAPI com Swagger UI.



12 . Gerenciamento de Dependências
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
Garante compatibilidade entre as versões das bibliotecas do Spring AI.

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
Configura a versão do Java e o processamento de anotações.
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
Facilita o empacotamento e execução da aplicação Spring Boot como um JAR independente.

