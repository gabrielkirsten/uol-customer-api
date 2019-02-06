
## Como usar o serviço 
A API construída trabalha no formato JSON (https://www.json.org/).  
**Estrutura do objeto customer (cliente)**  
```json  
{  
  "id": "6324cd27-5f67-40de-b541-6d91537137e4",  
  "name": "Gabriel Kirsten Menezes",   
  "age": 24  
}  
```  
Onde:
- id (UUID): Identificador único do *customer* (cliente).
- name (String): Nome do *customer* (cliente).
- age (Integer): Idade do *customer* (cliente).

### Consultar um Cliente por id  
**Method**: GET    
**URL**: http://localhost:8080/rest/costumers/{id}    
**Retorna**: Objeto *customer* requisitado.    
**Parâmetros**: 
	- id: ID do cliente a ser consultado.
    
### Criar um Cliente    
**Method**: POST    
**URL**: http://localhost:8080/rest/costumers    
**Retorna**: Objeto *customer* adicionado.    
**Parâmetros**: 
	- Objeto *customer* no corpo da requisição.

### Alterar um Cliente    
**Method**: PUT    
**URL**: http://localhost:8080/rest/costumers    
**Retorna**: Objeto *customer* alterado.    
**Parâmetros**: 
	- Objeto *customer* no corpo da requisição.
    
### Listar todos os Clientes salvos    
**Method**: GET    
**URL**: http://localhost:8080/rest/costumers    
**Retorna**: Uma lista de objetos *customer*.
  
### Remover Cliente por id    
**Method**: DELETE    
**URL**: http://localhost:8080/rest/costumers/{id}    
**Parâmetros**: 
	- id: ID do cliente a ser deletado.
	
*A API possui também uma documentação que pode ser acessada pelo link [http://localhost:8080/rest/swagger-ui.html](http://localhost:8080/rest/swagger-ui.html)*
    
## Quais ferramentas foram usadas? (e porque foram as escolhidas) 
### - Linguagem  
Java 8. Escolhida por fazer parte do scopo do problema proposto.   
  
### - Banco de dados
Para facilitar a execução, foi utilizado um *in-memory database*, chamado  [H2 Database Engine](http://www.h2database.com/html/main.html). O H2 funciona somente em tempo de execução, facilitando a execução do projeto. Também possui um console que pode ser acessado pelo endereço [http://localhost:8080/rest/h2](http://localhost:8080/rest/h2).  
- Credenciais para conexão:  
  - Usuário: sa  
  - Senha: admin  
  
**ATENÇÃO**: O banco de dados possui uma memória **volátil**, para cada inicialização da aplicação o banco será reconstruído!  

### - Acesso aos dados
Para o acesso aos dados foi utilizado o **Spring Data JPA**, que fornece uma abstração simples de acesso aos dados e independente da tecnologia de banco de dados utilizada. 
    
### - Construção dos DTOs 
Para construir os DTOs dos objetos retornados, foi utilizado o modelmapper (http://modelmapper.org/). Oferece uma maneira fácil de converter um objeto em outro (no caso, uma entidade para um DTO da entidade).  
  
### - Comunicação com as APIs de terceiros  
Para esse ponto foi utilizado o **Feign** do Spring Cloud, que permite a escrita de clientes para WEB Services mais simples e padronizados.    
#### Circuit Breaker (Hystrix)  
O Spring Feign também permite a integração com o **Hystrix**, O Hystrix foi utilizado para que seja possível configurar os fallbacks do Feign.
  
## Como executar, testar, empacotar e entregar o projeto 

### Como executar, testar e empacotar o projeto  
**Build realizado com Maven** Execute o seguinte comando no diretório raiz do projeto    
```bash 
$ mvn clean install  
``` 
O comando utiliza os goals **clean** e **install** do Maven para baixar as dependencias do projeto, testar e gerar o ``Jar`` da aplicação localizado no diretório **target**.    
     
Sendo uma aplicação SpringBoot, basta apenas executar o ``Jar`` localizado no diretório **target** do projeto, com o comando padrão:    
```bash 
$ java -jar customer-api-0.0.1-SNAPSHOT.jar 
``` 
Com a execução do comando a aplicação iniciará no *servlet container* `Tomcat`.    
    
## Abordagens aplicadas para resolução dos problemas 
### [PROBLEMA] A consulta de Cliente por ID será altamente requisitada 
Para esse ponto, foi implementado o Cache do Spring. Reduzindo o número de execuções com base nas informações disponíveis no cache.    
  
### [PROBLEMA] Ao criar um cliente, apenas para fins estatísticos e históricos, busque qual a localização geográfica de quem executou a requisição, usando o IP de origem  
Foi adicionada uma nova tabela no banco de dados (customer_registration_logs), que armazena os seguintes valores:  
- **MAX_TEMPERATURE**: Temperatura máxima, no dia de cadastro, da cidade mais próxima.  
- **MIN_TEMPERATURE**: Temperatura minima, no dia de cadastro, da cidade mais próxima.  
- **CUSTOMER_ID**: ID do customer (cliente) adicionado.  
    
## Instruções para como montar o ambiente de produção onde os serviços devem ser executados  
O projeto conta com o Docker para auxiliar o deploy em produção. 
  
## Descrição do problema 
Premissas:    
- Serão avaliadas todas as características da solução apresentada    
- Caso não saiba por onde começar, procure algum tutorial de criação de CRUD Rest com Spring Boot    
- Caso tenha dificuldades ou não saiba como continuar, entregue até onde conseguir e explique quais problemas teve    
- Usamos Java em nossos sistemas    
- Considere apenas a parte backend. Não é necessário desenvolver tela/formulário, apenas os endpoints REST    
- Um cliente é composto apenas por nome e idade    
- API aberta de geolocalização por IP https://www.ipvigilante.com/    
- API aberta de clima por geolocalização https://www.metaweather.com/api/    
- Quando executar a busca de clima por geolocalização, caso não exista a cidade especifica de origem, utilize o resultado mais próximo.    
    
Sua tarefa é desenvolver os serviços REST abaixo:    
- Criar um Cliente    
- Alterar um Cliente    
- Consultar um Cliente por id    
- Listar todos os Clientes salvos    
- Remover Cliente por id    
    
Ao criar um cliente, apenas para fins estatísticos e históricos, busque qual a localização geográfica de quem executou a requisição, usando o IP de origem. Com a localização geográfica, consulte qual é a temperatura máxima e mínima do dia da requisição de criação no local do IP de origem. Salve essa informação e a associe ao cliente resultado da requisição de origem.    
    
Tenha em mente que a consulta de Cliente por ID será altamente requisitada.    
    
Junto com o código é necessário entregar uma documentação que contenha os itens abaixo:    
- Como usar os serviços    
- Quais ferramentas foram usadas (e porque essas foram as escolhidas)    
- Qualquer infraestrutura adicional necessária para executar, testar, empacotar e entregar seu projeto    
- Como executar, testar, empacotar e entregar o seu projeto    
- Instruções para como montar o ambiente de produção onde seus serviços devem ser executados (preferencialmente citando ferramentas e processos)