# AZ Ship API

API desenvolvida para o DESAFIO AZ SHIP.

## Documentação da API

A documentação da API é fornecida usando o padrão OpenAPI 3.0.1. Você pode visualizar a documentação interativa da API acessando o endpoint [http://localhost:8081/swagger-ui](http://localhost:8081/swagger-ui).

## Endpoints

A seguir estão alguns dos principais endpoints da API:

### Ship

#### `GET /ships/{id}`

Recupera informações do frete pelo ID.

#### `PUT /ships/{id}`

Atualiza informações do frete pelo ID.

#### `DELETE /ships/{id}`

Exclui o frete pelo ID.

#### `GET /ships`

Recupera todas os fretes de forma paginada.

#### `POST /ships`

Cria um novo frete.


### Client

#### `GET /clients/{id}`

Recupera informações do cliente pelo ID.

#### `PUT /clients/{id}`

Atualiza informações do cliente pelo ID.

#### `DELETE /clients/{id}`

Exclui o cliente pelo ID.

### Property

#### `GET /properties/{id}`

Recupera informações da propriedade pelo ID.

#### `PUT /properties/{id}`

Atualiza informações da propriedade pelo ID.

#### `DELETE /properties/{id}`

Exclui a propriedade pelo ID.

#### `GET /properties`

Recupera todas as propriedades.

#### `POST /properties`

Cria uma nova propriedade.


## Executando Localmente

Certifique-se de ter o docker configurado corretamente e execute a aplicação localmente usando os seguinte comando:


