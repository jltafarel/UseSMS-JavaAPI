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
```
	
	UseSMS.getAuthToken();
	
* Para renovar a sessão por mais 10 minutos, use o ping:
```

	UseSMS.ping(token);

* Envie um SMS. Este método retorna um ID único para a mensagem:
```

	UseSMS.sendSMS(token, telefone, mensagem);
	
* Busque o status de uma mensagem:
```

	UseSMS.getMessageStatus(token, id_mensagem);