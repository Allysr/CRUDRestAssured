## CRUD Rest Assured

<h1 align="center"></h1>

### 🔖 Como executar o projeto:
```diff 
• git clone git@github.com:Allysr/CRUDRestAssured.git
• cd CRUDRestAssured
```

### 🔖 Testes
####  GET
- [X] Validar lista de usuários com status code 200
- [X] Validar se o formato da resposta é JSON

####  GET by ID
- [X] Validar usuário com status code 200
- [X] Validar se o formato da resposta é JSON
- [X] Validar status code 404 ao buscar usuario inexistente

####  POST
- [x] Validar envio do usuário com status code 201
- [x] Validar status code 400 não enviando campos obrigatórios
- [x] Validar status code 400 ao enviar CPF inválido
- [x] Validar status code 400 ao tentar cadastrar CPF existente

####  PUT
- [x] Validar status code 200 ao atualizar usuário com sucesso
- [x] Validar status code 400 ao enviar CPF inválido
- [x] Validar status code 400 ao enviar CPF existente na listagem
- [x] Validar status code 404 ao tentar atualizar usuário inexistente

####  DELETE
- [x] Validar status code 204 ao excluir usuário com sucesso
- [x] Validar status code 404 ao tentar excluir usuário inexistente


API utilizada: https://teste-deploy-d69a89680fb9.herokuapp.com/swagger-ui/index.html#/Usu%C3%A1rio/atualizar
