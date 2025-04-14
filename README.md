
# Projeto Angular - Atlântida Pescados

## Visão Geral
Este é um projeto desenvolvido em Angular para simular um E Commerce de pescados, tanto como a sua área de admnistrador. Ele utiliza as seguintes tecnologias:

- **Angular 17**
- **TypeScript**
- **Node**
- **Spring**

## FIGMA DO PROJETO
O layout visual da aplicação foi desenvolvido no Figma e serve como referência para a interface de usuário.

Acesse o protótipo através do link abaixo:  
[🔗 Figma - Atlântida Pescados](https://www.figma.com/file/EXEMPLO/Atlantida-Pescados)

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

A BFF utiliza **Spring Boot**, expõe endpoints REST e fornece documentação via Swagger.

## DOCUMENTAÇÃO BACK END - SWAGGER
A API utilizada neste projeto possui documentação disponível via Swagger, facilitando o consumo e testes dos endpoints.

Acesse a documentação do back-end no endereço:  
[🔗 Swagger - Documentação da API](http://localhost:8080/swagger-ui.html)
>>>>>>> Stashed changes
