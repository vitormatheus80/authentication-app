# authentication-app
Essa aplicação Spring Security configura a autenticação de usuários, permitindo a geração de tokens JWT para autenticar usuários com senha correta e verifica a validade desses tokens ao acessar um endpoint protegido.

A aplicação de autenticação está completamente configurada para uso. O objetivo da aplicação é demonstrar como realizar a autenticação de usuários usando o Spring Security. Temos dois endpoints: o primeiro endpoint "/api/authentication" é do tipo POST, onde esperamos um corpo com o email e a senha do usuário que está tentando se autenticar. A aplicação irá procurar o usuário no banco de dados H2 que foi configurado ao executar a aplicação. Se o usuário existir no banco de dados, será realizada a verificação da senha, que está armazenada de forma criptografada no banco. Se a senha informada estiver correta, será gerado um token JWT para o usuário em questão, com validade de 8 horas.

O segundo endpoint é o "/api/authentication/check-token", do tipo GET. Você deverá informar o token na chamada, usando a autorização do tipo "Bearer Token". Nesse caso, você deve fornecer o token JWT. A aplicação, então, passa por um filtro que verifica se o token ainda está válido ou não. Se o token não estiver mais disponível, a autorização será negada e será retornada uma mensagem com o status code 401.

Usar essa chamada para se autenticar no endpoint "/api/authentication"

```json
{
    "email":"vitormatheus80@gmail.com",
    "password":"Teste123$"
}
```

O usuario acima é inserido no banco de dados H2 ao subir a aplicação com um script sql, isso é feito usando o Flyway Migration

## Tecnologias utilizadas
* Java 17
* Spring boot
* JPA
* Lombok
* Spring Security
* JWT
* Flyway Migration

<em>Desenvolvido por: Vitor Almeida</em>
