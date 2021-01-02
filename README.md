# persistence-ejb3

#### Esse é um pequeno projeto para estudos das tecnologias do Jakarta EE 8. O projeto é baseado na apostila "K22 - Desenvolvimento Web Avançado com JSF2, EJB3.1 e CDI" da K19 Treinamentos. Ele contém as resoluções dos exercícios do capítulo 5 (Persistência), capítulo 6 (Transações), capítulo 8 (Interceptadores) e capítulo 9 (Scheduling).

Esse projeto permite salvar e visualizar dados de produtos em geral. As tecnologias utilizadas foram:

* EJB3 (Enterprise JavaBeans)
* JSF (JavaServer Faces)
* CDI (Contexts and Dependency Injection)
* JPA (Java Persistence API)

## Projeto em execução no navegador

As palavras **github**, **java** e **ejb** foram adicionadas em uma classe que serve para censurar palavras utilizando o Interceptor do Jakarta EE.
No lugar dessas palavras, é armazenado no banco de dados a palavra **!CENSURADO!**.

![](https://user-images.githubusercontent.com/37079133/100173691-c2f32f00-2ea9-11eb-9463-8530b9571328.gif)

A interface TimerService do EJB foi utilizada para criar um temporizador que muda o Produto em Destaque a cada 5 segundos.


## Softwares usados no desenvolvimento

* [OpenJDK 11 (LTS) - JVM Eclipse OpenJ9](https://adoptopenjdk.net)
* [WildFly 21.0.0](https://www.wildfly.org/downloads)
* [Eclipse IDE 2020-09 for Enterprise Java](https://www.eclipse.org/downloads/packages)
* [MySQL Community Server 8.0](https://dev.mysql.com/downloads/mysql)


## Como executar o projeto


O projeto foi desenvolvido para funcionar no servidor de aplicações WildFly 21, então algumas configurações extras são necessárias.


Na pasta do WildFly, ir até modules\system\layers\base\com e criar uma pasta chamada mysql, depois outra com o nome main.


O caminho completo fica assim: ...\wildfly-21.0.0.Final\modules\system\layers\base\com\mysql\main.


Baixar o arquivo jar do mysql-connector no [repositório do Maven](https://mvnrepository.com/artifact/mysql/mysql-connector-java) e colar na pasta main.


Ainda na pasta main, crie um arquivo chamado module.xml e cole o seguinte texto dentro:


```
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="com.mysql">
<resources>
	<resource-root path="mysql-connector-java-8.0.22.jar" />
</resources>
<dependencies>
	<module name="javax.api"/>
	<module name="javax.transaction.api"/>
</dependencies>
</module> 
```


É necessário adaptar a linha abaixo para a versão do MySQL que foi baixada

  

```
<resource-root path="mysql-connector-java-8.0.22.jar" />
```
 

Após isso, é necessário ir no diretório wildfly-21.0.0.Final\standalone\configuration e editar o arquivo standalone.xml.

  

Dentro da tag datasources, adicione o seguinte texto:
  

```
<datasource jta="true" jndi-name="java:/jdbc/persistence-ejb3" pool-name="persistence-ejb3" enabled="true" use-java-context="true" use-ccm="true">
	<connection-url>jdbc:mysql://localhost:3306/persistence-ejb3?useSSL=false&amp;allowPublicKeyRetrieval=true&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;useTimezone=true&amp;serverTimezone=America/Sao_Paulo</connection-url>
	<driver>com.mysql</driver>
	<security>
		<user-name>root</user-name>
		<password>root</password>
	</security> 
</datasource>
```

Substitua o nome de usuário e a senha para a versão utilizada no seu banco de dados.
 

Dentro da tag drivers, adicione o seguinte texto:

```
<driver name="com.mysql" module="com.mysql">  
	<driver-class>com.mysql.cj.jdbc.Driver</driver-class>
	<xa-datasource-class>com.mysql.cj.jdbc.MysqlXADataSource</xa-datasource-class>
</driver>
```
  

O script para criar o banco de dados está no arquivo "MySQL8_persistence-ejb3.sql".

Após esses passos, o projeto deve ser executado no servidor WildFly 21. A URL de acesso à página é: http://localhost:8080/persistence-ejb3

### Autor

Feito por Israel Ferreira. 👋🏽 Entre em contato!
[![Email Badge](https://img.shields.io/badge/-israelferreira5@outlook.com-c14438?style=for-the-badge&color=blue&link=mailto:israelferreira5@outlook.com)](mailto:israelferreira5@outlook.com)
