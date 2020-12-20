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
### Anotacao projeto lombok
* *@Data*: Esta anotação gera as referencias dos get's e set's das classes 
* *@Builder*: Esta anotação  gera o padrao de projeto para instancia de objetos
* *@AllArgsConstructor*: Esta anotação gerar os construtores com todos argumentos
* *@NoArgsConstructor*: Esta anotação gerar os construtores sem argumentos

Para informar que vamos fazer um acesso via HTTP devemos ter uma classe controller
e utilizar a anotação: *@RestController*.
para definir uma uri principal para acesso a API  utilizamos a anotacao: *@RequestMapping* e como parametro passamos o endereco que iremos utilizar para acessar so metodos desta classe por exemplo *@RequestMapping("api/v1/people")*

#### Trabalhando com o JPA 
##### O Jpa nos permite com hibernate mapear nossas classes em entididades no banco de dados, utilizando uma técninca de ORM (Mapeamento de Objeto Relacional)
###### Para realizar este mapeamento utilizamos as seguintes anotações
* *@Entity* : Dizemos que a esta classes sera uma entidade no banco de dados. *OBS:* Adicionamos esta anotação acima da Assinatura de nossa classe
* *@Id* : Dizemos que este atributo sera um identificador unico.*OBS:* Adicionamos esta anotação acima da Assinatura do atributo id
* *@GeneratedValue(strategy = GenerationType.IDENTITY)* : Dizemos o atributo Id tera uma estrategia de geração de valor automatica e incremental. *OBS:* Esta anotação deve vir abaixo da anotação *@Id*
* *@Column*: Diz que um atributo sera uma coluna na tabela do banco de dados, esta anotação tem diversos parametros como: name: serve para definir o nome da coluna no banco de dados; nullable: para dizer se o valor dessa coluna pode ser inserido vazio ou não; length: para definir o tamanho máximo que nosso campo pode ocupar; unique: diz se o valor desta coluna é exclusivo;
* ###### Para fazer a relação de chave estrágeira temos varias anotações, uma para cada contexto 
* *@OnetoOne*   : Relacionamento de um para um 
* *@OnetoMany*  : Relacionamento de um para muitos
* *@ManytoOne*  : Relacionamento de muitos para um 
* *@ManytoMany* : Relacionamento de muitos para muitos

#### Também dentro da dependecia JPA temos uma biblioteca que permite o uso dos metodos CRUD já implementados, ou seja você pode: inserir,  atualizar, remover e outros apenas utilizando os metodos da interface JPA repository.
##### Para utilizar criamos uma interface e utilizamos a herança, exemplo:
* public interface PessoaRepository extends JpaRepository<T,T>
###### O primeiro parametro da JpaRepository<1,T> Deve ser a classe que queremos persistir no banco de dados, neste exemplo seria a classe pessoa
###### O segundo parametro da JpaRepository<T,2> Deve ser o tipo do id da classe que queremos persistir no banco de dados
* public interface PessoaRepository extends JpaRepository<Pessoa, Long>