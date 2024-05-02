## CRUD Rest Assured

<h1 align="center"></h1>

#### 🔖 Como executar o projeto:
```diff 
• git clone
• cd CRUDRestAssured
```

####  🔖 GET
- [X] Validar lista de usuários com status code 200
- [X] Validar se o formato da resposta é JSON

####  🔖 GET by ID
- [X] Validar usuário com status code 200
- [X] Validar se o formato da resposta é JSON
- [X] Validar status code 404 ao buscar usuario inexistente


####  🔖 POST
- [ ] Validar envio do usuário com status code 200
- [ ] Validar status code 400 não enviando campos obrigatórios
- [ ] Validar status code 400 ao enviar CPF inválido
- [ ] Validar status code 400 ao tentar cadastrar CPF existente

####  🔖 PUT
- [ ] Validar status code 200 ao atualizar usuário com sucesso
- [ ] Validar status code 400 ao enviar CPF inválido
- [ ] Validar status code 400 ao enviar CPF existente na listagem
- [ ] Validar status code 404 ao atualizar usuário inexistente



####  🔖 DELETE
- [ ] Validar status code 200 ao excluir usuário com sucesso
- [ ] Validar status code 404 ao excluir usuário inexistente


API utilizada: https://teste-deploy-d69a89680fb9.herokuapp.com/swagger-ui/index.html#/Usu%C3%A1rio/atualizar
