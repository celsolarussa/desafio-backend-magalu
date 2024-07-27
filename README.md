# Desafio Backend Magalu

## Resumo do desafio
- Construir uma aplicação RESTFul com formato JSON para cadastrar, retornar e alterar agendamentos.
- Confira o enunciado completo [aqui](https://github.com/celsolarussa/desafio-backend-magalu/PROBLEM.md)


## Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Scheduler
- MySql
- Docker
- Postman


## Instalação e Configuração

### Variáveis de Ambiente

Para rodar este projeto, você precisará adicionar as seguintes variáveis de ambiente ao seu arquivo `.env`

`DB_HOST` - O endereço do seu banco de dados (ex: localhost, mysql)

`DB_NAME` - O nome do seu banco de dados (ex: magaludb)

`DB_USER` - O usuário do seu banco de dados

`DB_PASSWORD` - A senha do seu banco de dados

Exemplo de arquivo `.env`:

```dotenv
DB_NAME=magaludb
DB_USER=myuser
DB_PASSWORD=secret
```

### Deploy com Docker

Este projeto utiliza Docker para facilitar o deploy e a configuração do ambiente. Para fazer o deploy da aplicação, siga os passos abaixo:

1. Certifique-se de que o Docker e o Docker Compose estão instalados em sua máquina. Caso contrário, você pode baixá-los e instalá-los a partir dos links oficiais: [Docker](https://docs.docker.com/get-docker/) e [Docker Compose](https://docs.docker.com/compose/install/).

2. Abra um terminal na raiz do projeto.

3. Execute o seguinte comando para iniciar a aplicação:

```bash
docker compose up
```

4. A aplicação estará disponível em `http://localhost:8080`.