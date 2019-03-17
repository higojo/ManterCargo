> O projeto foi desenvolvido com a seguinte arquitetura:
• JEE;
• Maven Project;
• JSP/Servlet;
• JPA/Hibernate;
• PostgreSQL;
• Tomcat 7;
• HTML/CSS;

> O arquivo comprimido possui dentro:
• Servidor Apache Tomcat 7 configurado;
• Workspace do projeto;
• Script completo de criação do banco de dados;
• Script para popular combos;

> O código possui boas práticas de programação como:
• Singleton Conection;
• Métodos reusáveis;
• Lógica dinâmica;
• Classe genérica;
• Utilização de constante;
• Comentários;
• Documentação;

> Opções para criação do banco de dados:
1- Criar a database de forma manual com as informações de driver, url, user e password, disponíveis no arquivo "persistence.xml". Depois subir o servidor com a <property> (hibernate.hbm2ddl.auto) do Hibernate com value="create". Depois executar os scripts (exemplos) de inserts para popular combos (script-inserts.sql);
2- Executar os scripts do arquivo "script-completo.sql";

> Informações básicas para acesso:
• Importar como Maven Project;
• Rodar o maven install no projeto;
• Porta do Tomcat: 8080;
• Rota inicial: mantercargo/cargoServlet;

> O sistema trata-se de um projeto web (consiste na necessidade de um build para geração de um compilado .war para leitura do servidor e funcionamento correto do sistema). Não foi utilizado nenhum framework frontend, foi feito nativo puro e sem estilo.

> O sistema está incompleto (não foi desenvolvido algumas RNs). Foi realizado repasse disso para a: Veronica Pereira de Carvalho.