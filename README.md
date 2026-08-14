# Gerenciador_de_Eventos_API

API de Gerenciamento de Eventos

Backend de uma API REST para gerenciamento de eventos, desenvolvido com Java e Spring Boot.

📋 Funcionalidades
Cadastro de administradores
Consulta de todos os administradores
Consulta de administradores por ID
Exclusão de administradores
===============================================
Cadastro de eventos
Consulta de todos os eventos
Consulta de evento por ID
Atualização da data e localização dos eventos
Exclusão de eventos
Validação dos dados recebidos
Persistência dos dados em banco de dados
===============================================
🛠️ Tecnologias
Java
Spring Boot
Spring Web
Spring Data JPA
Hibernate
PostgreSQL
Maven
===============================================
src/
├── main/
│   ├── java/
│   │   └── com.example.eventos/
│   │       ├── controller/
│   │       ├── dto/
│   │       │   ├── patch/
│   │       │   ├── request/
│   │       │   └── response/
│   │       ├── mapper/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── security/
│   │       └── service/
│   └── resources/
│       └── application.properties/
└── test/
    └── java/

===============================================
A aplicação segue uma separação de responsabilidades entre as principais camadas:

- Controller: Responsável por receber as requisições HTTP, encaminhá-las para a camada de serviço e retornar as respostas apropriadas.
- DTO/Patch: Define os dados utilizados em atualizações parciais dos recursos.
- DTO/Request: Define os dados recebidos pela API nas requisições, evitando a exposição direta das entidades.
- DTO/Response: Define os dados retornados pela API nas respostas, controlando quais informações são expostas ao cliente.
- Mapper: Responsável pela conversão entre entidades e DTOs, mantendo essa responsabilidade separada das demais camadas.
- Model: Representa as entidades e estruturas de dados utilizadas pela aplicação.
- Repository: Responsável pelo acesso e persistência dos dados no banco de dados.
- Security: Responsável pelas configurações relacionadas à autenticação, autorização e segurança da aplicação.
- Service: Concentra as regras de negócio da aplicação e coordena as operações entre as diferentes camadas.
⚙️ Pré-requisitos

Para executar o projeto, é necessário possuir instalado:

Java JDK 25
Maven 3.9.x
PostgreSQL

Verifique a instalação do Java com:

java -version


E do Maven com:

mvn -version
===============================================
📥 Instalação

Clone o repositório:

git clone URL_DO_REPOSITORIO

Acesse o diretório do projeto:

cd NOME_DO_PROJETO

Instale as dependências e compile o projeto:

./mvnw clean install

No Windows, também é possível utilizar:

mvnw.cmd clean install
===============================================
🔐 Configuração

Configure as informações necessárias para conexão com o banco de dados no arquivo de configuração da aplicação.

Exemplo:

spring.datasource.url=jdbc:postgresql://meu-servidor.com:5432/eventos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

▶️ Executando a aplicação
===============================================
Para executar o projeto utilizando o Maven Wrapper:

Linux/macOS
./mvnw spring-boot:run

Windows
mvnw.cmd spring-boot:run


Por padrão, a aplicação estará disponível em:

http://localhost:8080

📡 Endpoints
Administrador
Método	Endpoint	Descrição
GET	    /api/administrador	    Lista todos os administradores
GET	    /api/administrador/{id}	Busca um administrador pelo ID
POST    /api/administrador	    Cria um novo administrador
PATCH	  /api/administrador/{id}	Atualiza um administrador
DELETE	/api/administrador/{id}	Remove um administrador
Exemplo de criação de administrador

POST /api/administrador

{
  "nome": "João Carlos",
  "email": "jcarlos@gmail.com",
  "senha": "carlos1234"
}

Exemplo de resposta
{
  "id": 1,
  "nome": "João Carlos",
  "email": "jcarlos@gmail.com",
  "senha": "carlos1234"
}

Eventos
Método	Endpoint	Descrição
GET	    /api/eventos	    Lista todos os eventos
GET	    /api/eventos/{id}	Busca um evento pelo ID
POST    /api/eventos	    Cria um novo evento
PATCH	  /api/eventos/{id}	Atualiza um evento
DELETE	/api/eventos/{id}	Remove um evento
Exemplo de criação de evento

POST /api/eventos

{
  "nome": "Festa de 15 Anos",
  "data": "2026-08-14",
  "localizacao": "Petrópolis-RJ",
  "imagem": {URL da imagem},
  "admin": {
    "id": 1
  }
}

Exemplo de resposta
{
  "id": 1,
  "nome": "Festa de 15 Anos",
  "data": "2026-08-14",
  "localizacao": "Petrópolis-RJ",
  "imagem": {URL da imagem}
  "adminId": 1
}
===============================================
🧪 Testes

Para executar os testes automatizados:

./mvnw test

No Windows:

mvnw.cmd test
===============================================
📖 Documentação da API

http://localhost:8080/swagger-ui/index.html
===============================================
🔒 Segurança

Utilize variáveis de ambiente ou arquivos de configuração que não sejam versionados pelo Git.
===============================================
📌 Status

✅ Completo
===============================================
👨‍💻 Autor

Gabriel Mendonça
===============================================
📄 Licença

Projeto desenvolvido como parte de um processo seletivo para demonstrar grau de conhecimento em desenvolvimento backend com Java e Spring Boot.
