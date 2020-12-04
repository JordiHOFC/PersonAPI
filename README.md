# API  para gerencia de pessoas com Spring boot e spring data
Neste repositorio serão abordados conceitos sobre  padrão arquitetura Rest, POO e como utilizar o padrão de injeção de dependencias em java.

## Representational State Transfer (Rest)
é um padrao arquitetural  de comunicação de sistemas, foi proposto para melhorar o SOAP e melhorar a integrar os sistemas atraves do protocolo HTTP.
Utiliza-se as tradicionais operações de POST,GET,PUT,DELETE E O PATCH.
* POST   : para criar um novo objeto.
* GET    : para fazer uma consulta
* PUT    : para fazer uma alteração
* DELETE : para apagar um objeto do banco de dados
* PATCH  : para fazer uma validação 


Aprendendo a criar uma API, Com spring boot e spring data, para gerencia de pessoas.

Para informar que vamos fazer um acesso via HTTP devemos ter uma classe controller
e utilizar a anotação: *@RestController*.
para definir uma uri principal para acesso a API  utilizamos a anotacao: *@RequestMapping* e como parametro passamos o endereco que iremos utilizar para acessar so metodos desta classe por exemplo *@RequestMapping("api/v1/people")*