
# Projeto Angular - Atlântida Pescados

## Visão Geral
Este é um projeto desenvolvido em Angular para simular um E Commerce de pescados, tanto como a sua área de admnistrador. Ele utiliza as seguintes tecnologias:

- **Angular 17**
- **TypeScript**
- **Nest**
- **Spring**

## FIGMA DO PROJETO
O layout visual da aplicação foi desenvolvido no Figma e serve como referência para a interface de usuário.

Acesse o protótipo através do link abaixo:  
[🔗 Figma - Atlântida Pescados](https://www.figma.com/design/4UtcTVA6LhZYmXx15MyCVV/E-Commerce?node-id=0-1&t=Ret8sq7ckXqS6p5O-1)

## FRONT END

## Requisitos
Antes de rodar o projeto, certifique-se de ter instalado:
- **Node.js** (versão recomendada: 18+)
- **Angular CLI**
  ```sh
  npm install -g @angular/cli
  ```

## Instalação
Para instalar as dependências do projeto, execute:
```sh
npm install
```

## Execução
Para rodar o projeto em ambiente de desenvolvimento:
```sh
ng serve
```
A aplicação estará disponível em `http://localhost:4200/`.

## Estrutura do Projeto
```
/src
  |-- app/
  |   |-- components/       # Componentes reutilizáveis
  |   |-- interfaces/       # Interfaces
  |   |-- pages/            # Páginas principais
  |   |-- services/         # Serviços e comunicação com API
  |   |-- view-models/      # Modelos de dados
  |-- assets/               # Imagens e arquivos estáticos
  |-- environments/         # Configurações de ambiente
```

## Padrões de Desenvolvimento
- **Componentes:** Devem ser nomeados usando `kebab-case` (`meu-componente.component.ts`).
- **Serviços:** Devem ser nomeados com `camelCase` e terminando em `Service` (`userService.ts`).
- **Métodos:** Devem ser descritivos e seguir `camelCase` (`getUserById`).

Exemplo de service:
```ts
@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private http: HttpClient) {}
  
  /**
   * Obtém um usuário pelo ID.
   */
  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`/api/users/${id}`);
  }
}
```

## ESTRUTURA DA BFF (BACKEND FOR FRONTEND)
A BFF é responsável por intermediar a comunicação entre o front-end Angular e os microsserviços da aplicação, realizando adaptações de dados e agregações quando necessário.

```
/bff
  |-- data-access/
  |   |-- dtos/              # Objetos de transferência de dados
  |   |-- view-models/       # Modelos utilizados pelo front-end
  |
  |-- src/
      |-- controllers/       # Endpoints expostos ao front-end
      |-- services/          # Lógica intermediária e regras de negócio
```

O BFF utiliza **Spring Boot**, expõe endpoints REST e fornece documentação via Swagger.

Para rodar o BFF localmente, abra o terminal e digite, isso é essencial para mostrar as tabelas e requisições
```sh
npm run start
```

## 📚 DOCUMENTAÇÃO DO BACK-END

Acesse a documentação interativa da API via Swagger no link abaixo:  
[🔗 Swagger - Documentação da API](https://atlantida-dad.onrender.com/swagger-ui/index.html#)

---

## 📦 DEPENDÊNCIAS DO PROJETO

### 1. Spring Boot
- **Redis Reativo**
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
```
Integração reativa com Redis usando Spring Data Redis + Project Reactor.

- **Web**
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
Suporte para desenvolvimento de APIs REST e MVC.

---

### 2. Inteligência Artificial
- **Neo4j Store**
```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-neo4j-store-spring-boot-starter</artifactId>
</dependency>
```
Armazenamento em grafo com Spring AI + Neo4j.

- **PostgresML**
```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-postgresml-spring-boot-starter</artifactId>
</dependency>
```
Integra Spring AI ao PostgresML (machine learning no banco de dados).

---

### 3. Kafka
```xml
<dependency>
  <groupId>org.springframework.kafka</groupId>
  <artifactId>spring-kafka</artifactId>
</dependency>
```
Comunicação assíncrona via Apache Kafka.

---

### 4. Lombok
```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <scope>provided</scope>
</dependency>
```
Evita boilerplate gerando métodos como `getters/setters` automaticamente.

---

### 5. Testes
- **Spring Boot Test**
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

- **Reactor Test**
```xml
<dependency>
  <groupId>io.projectreactor</groupId>
  <artifactId>reactor-test</artifactId>
  <scope>test</scope>
</dependency>
```

- **Kafka Test**
```xml
<dependency>
  <groupId>org.springframework.kafka</groupId>
  <artifactId>spring-kafka-test</artifactId>
  <scope>test</scope>
</dependency>
```

---

### 6. JPA
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
Integração com bancos relacionais via Hibernate e JPA.

---

### 7. PostgreSQL
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
</dependency>
```
Driver JDBC para conexão com PostgreSQL.

---

### 8. JavaFX
```xml
<dependency>
  <groupId>org.openjfx</groupId>
  <artifactId>javafx-graphics</artifactId>
  <version>21</version>
</dependency>
```
Biblioteca para interfaces gráficas com Java.

---

### 9. Azure
```xml
<dependency>
  <groupId>com.azure</groupId>
  <artifactId>azure-core</artifactId>
  <version>1.54.1</version>
</dependency>
```
Integração base com serviços da Microsoft Azure.

---

### 10. Geração de JSON Schema
```xml
<dependency>
  <groupId>com.github.victools</groupId>
  <artifactId>jsonschema-module-swagger-2</artifactId>
  <version>4.37.0</version>
</dependency>
```
Geração automática de schemas JSON com base no Swagger/OpenAPI.

---

### 11. Documentação da API
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.3.0</version>
</dependency>
```
Gera documentação Swagger a partir do código Spring.

---

### 12. Gerenciamento de Dependências
```xml
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
```
Garante compatibilidade entre bibliotecas Spring AI.

---

### 13. Plugins do Maven

- **Maven Compiler Plugin**
```xml
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
```

- **Spring Boot Maven Plugin**
```xml
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
```

---

## 🧾 SCRIPT SQL - ESTRUTURA DO BANCO DE DADOS

Abaixo está o script para criação completa das tabelas do banco de dados, incluindo **relacionamentos, constraints e dados padrão**:

```sql
DROP TABLE IF EXISTS pedido_carrinho CASCADE;
DROP TABLE IF EXISTS Pedido CASCADE;
DROP TABLE IF EXISTS Produto CASCADE;
DROP TABLE IF EXISTS Cartao CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;
DROP TABLE IF EXISTS Carrinho CASCADE;

CREATE TABLE Cliente (
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    endereco TEXT,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE Cartao (
    id_cartao SERIAL PRIMARY KEY,
    numero_cartao CHAR(16) UNIQUE NOT NULL,
    validade DATE NOT NULL,
    cvv CHAR(3) NOT NULL,
    bandeira VARCHAR(50) NOT NULL,
    tipo VARCHAR(10),
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Produto (
    id_produto SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL CHECK (preco >= 0),
    estoque INT NOT NULL CHECK (estoque >= 0),
    tipo VARCHAR(100) NOT NULL DEFAULT 'valor_default',
    imagem TEXT,
    peso NUMERIC
);

CREATE TABLE Carrinho (
    id_carrinho SERIAL PRIMARY KEY,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
);

CREATE TABLE Pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10,2) NOT NULL CHECK (valor_total >= 0),
    id_cartao INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_cartao) REFERENCES Cartao(id_cartao)
);

CREATE TABLE pedido_carrinho (
    id_pedido INT NOT NULL,
    id_carrinho INT NOT NULL,
    PRIMARY KEY (id_pedido, id_carrinho),
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
    FOREIGN KEY (id_carrinho) REFERENCES Carrinho(id_carrinho)
);

UPDATE Produto SET tipo = 'valor_default' WHERE tipo IS NULL;
```

> 💡 **Dica:** Execute esse script em um ambiente seguro, pois ele *dropa* as tabelas antes de criá-las. Ideal para resets de ambiente em desenvolvimento.

