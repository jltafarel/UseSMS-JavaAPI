UseSMS-JavaAPI
==============

API de acesso ao UseSMS. http://usesms.net.br/
 
Como usar:
---

* Compile o jar.
* Faça a configuração do seu usuário do UseSMS:

	Config.getInstance().setUsername("username");
	Config.getInstance().setPassword("password);
	
* Requisite o token de autenticação (o token tem validade de 10 minutos):
```java
	
	UseSMS.getAuthToken();
	
```
	
* Para renovar a sessão por mais 10 minutos, use o ping:
```java

	UseSMS.ping(token);

```

* Envie um SMS. Este método retorna um ID único para a mensagem:
```java

	UseSMS.sendSMS(token, telefone, mensagem);
	
```
	
* Busque o status de uma mensagem:
```java

	UseSMS.getMessageStatus(token, id_mensagem);
```