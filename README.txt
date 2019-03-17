> **_Projeto criado para agregar conhecimento próprio e prática de tecnologias._**

### Arquitetura do projeto:
* JEE;
* Maven Project;
* **JSP/Servlet;**
* JPA/Hibernate;
* PostgreSQL;
* Tomcat 7;
* HTML/CSS;

### O projeto possui:
* Servidor Apache Tomcat 7 configurado;
* Script completo de criação do banco de dados;
* Script para popular combos;
* Códigos do projeto;

### Opções para criação do banco de dados:
1. Criar a database de forma manual com as informações de driver, url, user e password, disponíveis no arquivo "persistence.xml". Depois subir o servidor com a <property> (hibernate.hbm2ddl.auto) do Hibernate com value="create". Depois executar os scripts (exemplos) de inserts para popular combos (script-inserts.sql);
2. Executar os scripts do arquivo "script-completo.sql";

### Informações básicas para acesso:
* Importar como Maven Project;
* Rodar o maven install no projeto;
* Iniciar o servidor Apache Tomcat e utilizar a porta: 8080;
* Rota inicial: mantercargo/cargoServlet;

### Boas práticas existentes no projeto:
* Singleton Conection;
* Método reusável;
* Lógica dinâmica;
* Classe genérica;
* Classe Útil;
* Utilização de constante;
* Comentário;
* Documentação;

> O sistema trata-se de um projeto web (consiste na necessidade de um build para geração de um compilado .war para leitura do servidor e funcionamento correto do sistema). Nenhum framework frontend foi utilizado, foi feito nativo puro e sem estilo.
