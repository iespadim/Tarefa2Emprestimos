# Testando um serviço WEB composto por classes com dependência

Este projeto contém 4 classes que visam
testar a funcionalidade de uma calculadora
de empréstimos

### CalculoDeJurosTests
A classe CalculoDeJurosTests é responsavel
pelos testes unitarios da classe CalculoDeJuros.
Esta classe é uma classe sem dependencias por 
isso nao foi necessário criar mocks.

### EmprestimoTests
A classe EmprestimoTestes é responsável pelos
testes da classe Emprestimo. Para testar apenas
a classe em questão foram usados mocks da classe
calculo de juros.

### IntegrationTests
Esta classe é responsável por testar as duas 
classes operando em conjunto. Aqui tanto Emprestimo
quanto CalculoDeJuros são instanciadas e o resultado
da interação é avaliado nos casos de teste

### EmprestimoApplicationTests
Esta classe é responsavel por fazer o projeto
spring rodar, fazendo com que o webservice rode
e que as chamadas aos endpoints sejam ativadas
realizando os calculos e retornando as mensagens como json.
O resultado é avaliado tanto no HTTP status code 
como no corpo da resposta