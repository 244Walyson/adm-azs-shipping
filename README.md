# AZ Ship API

APIs desenvolvida para o DESAFIO AZ SHIP.

## Descrição

O desafio-az e  o azShipMongo são o mesmo projeto mas desenvolvidos com diferente arquitetura e tecnologias.


### desafio-az
### **link aplicação REST na aws:** [***http://azship20240304ebcname202403040554.us-east-2.elasticbeanstalk.com***](http://azship20240304ebcname202403040554.us-east-2.elasticbeanstalk.com/swagger-ui/index.html)
O Desafio-Az foi desenvolvido com uma abordagem baseada em arquitetura Domain-Driven Design (DDD) e utiliza uma implementação REST. O banco de dados escolhido é o PostgreSQL, proporcionando uma base de dados relacional para garantir consistência e relacionamentos entre as entidades.

#### Tecnologias Utilizadas:

- **Arquitetura:** Domain-Driven Design (DDD)
- **Banco de Dados:** PostgreSQL (Relacional)
- **Implementação da API:** REST
- **CI/CD Inplantação:** Github Actions, AWS

### AzShipMongo

O azShipmongo, por outro lado, foidesenvolvido com uma arquitetura Hexagonal (Ports and Adapters) e utiliza o banco de dados MongoDB, um banco de dados NoSQL. A implementação da API foi feita usando graphql, proporcionando uma interface flexível para operações relacionadas a informações de frete.

- **Arquitetura:** Hexagonal (Ports and Adapters)
- **Banco de Dados:** MongoDB (NoSQL)
- **Implementação da API:** GraphQL

## Documentação da API

A documentação da API é fornecida usando o padrão OpenAPI 3.0.1. Você pode visualizar a documentação interativa da API acessando o endpoint [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html), o playground do grapQl pode ser acessado através do endpoint [http://localhost:8080/graphiql](http://localhost:8080/graphiql).


### Query

```graphql
query{
  findAllShips(param: "alex", page:1, pageSize: 1){
    content {
      id,
      createdAt,
      description,
      status,
      properties{
        name,
        value
      },
      client{
        id,
        name,
        email,
      }
    },
    isFirst,
    isLast,
    isEmpty,
    totalPages,
    totalElements,
    number,
    numberOfElements,
    size
  }
}

## Response

{
  "data": {
    "findAllShips": {
      "content": [
        {
          "id": "65e3e614fcc620398ca4e2db",
          "createdAt": "2024-03-03T02:53:08.153Z",
          "description": "descrição 6",
          "status": "ENTREGUE",
          "properties": [
            {
              "name": "cubagem",
              "value": 6500
            },
            {
              "name": "peso",
              "value": 13000
            }
          ],
          "client": {
            "id": "65e3e614fcc620398ca4e2d5",
            "name": "Alex Grey LTDA",
            "email": "alex@gmail.com"
          }
        }
      ],
      "isFirst": false,
      "isLast": false,
      "isEmpty": false,
      "totalPages": 3,
      "totalElements": 3,
      "number": 1,
      "numberOfElements": 1,
      "size": 1
    }
  }
}

### Um resultado semelhante pode ser alcançado atraves do endpoint
#### `GET /ships`
```

## Mutation

```graphql
mutation{
  insertShip(ship:{
    description: "Novo frete",
    status: AGUARDANDO_PAGAMENTO,
    properties: {
      name: "cubagem",
      value: 20000.00
    },
    client: {
      id: "65e3ee14dbd46a5fdbaba92c"
    }}){
    id,
    description,
    client {
      id,
      name
    },
    properties{
      name,
      value
    }
  }
}

## Response

{
  "data": {
    "insertShip": {
      "id": "65e3ee36dbd46a5fdbaba939",
      "description": "Novo frete",
      "client": {
        "id": "65e3ee14dbd46a5fdbaba92c",
        "name": "Maria Brown"
      },
      "properties": [
        {
          "name": "cubagem",
          "value": 20000
        }
      ]
    }
  }
}

## Um Resultado semelhante pode ser alcançado atraves do endpoint 
#### `POST /ships`

```
```graphql
## Atualizar Frete

mutation{
  updateShip(ship:{
    id: "65e3f5d06a499355dac75a0e",
    description: "Frete Atulaizado",
    status: AGUARDANDO_PAGAMENTO,
    properties: {
      name: "litros",
      value: 20000.00
    },
    client: {
      id: "65e3f5d06a499355dac75a0b"
    }}){
    id,
    description,
    client {
      id,
      name
    },
    properties{
      name,
      value
    }
  }
}

## Response

{
  "data": {
    "updateShip": {
      "id": "65e3f5d06a499355dac75a0e",
      "description": "Frete Atulaizado",
      "client": {
        "id": "65e3f5d06a499355dac75a0b",
        "name": "Maria Brown"
      },
      "properties": [
        {
          "name": "litros",
          "value": 20000
        }
      ]
    }
  }
}

## Um Resultado semelhante pode ser alcançado atraves do endpoint 
#### `PUT /ships`

```

```graphql
## Excluir Frete

mutation{
  deleteShip(id: "65e3f34d2797472c1af2a662"){
    httpStatus
  }
}

## Response

{
  "data": {
    "deleteShip": {
      "httpStatus": 204
    }
  }
}

## Um Resultado semelhante pode ser alcançado atraves do endpoint 
#### `DELETE /ships`

```
## Clients
```graphql
query{
  findAllClients{
    content{
      id,
      name,
      email,
      cnpj,
      phone
    }
  }
}

## Response

{
  "data": {
    "findClientById": {
      "id": "65e3f5d06a499355dac75a0b",
      "name": "Maria Brown",
      "email": "maria@gmail.com",
      "cnpj": "4356476543",
      "phone": "31945654323"
    }
  }
}
```
## Outros Endpoints da aplicação REST

A seguir estão alguns dos principais endpoints da API:

### Client

#### `GET /clients/{id}`

Recupera informações do cliente pelo ID.

#### `PUT /clients/{id}`

Atualiza informações do cliente pelo ID.

#### `DELETE /clients/{id}`

Exclui o cliente pelo ID.

## Executando Localmente

Certifique-se de ter o docker configurado corretamente para executar a aplicação
#### Caso não possua o docker compose pode instalar usando o comando:
```bash
sudo apt-get install docker-compose
```

### Para executar o projeto basta executar os seguintes comandos no terminal

```bash
git clone git@github.com:244Walyson/adm-azs-shipping.git
cd adm-azs-shipping
docker-compose up --build
```
*esse processo pode demorar um pouco, ate que a aplicação seja buildada e o maven instale as dependencias*

# A aplicação REST estara disponivel na porta 8081 e o graphql na porta 8080


