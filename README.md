<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

  <h1>Gestão de Funcionários</h1>

  <p>
    Projeto em Java para gerenciar funcionários.
  </p>

<h2>Sobre o projeto</h2>
  <p>
    A proposta desse projeto foi simular um sistema de gestão de funcionários,
    trabalhando com cadastro, manipulação de dados.
  </p>

  <p>
	Os dados são armazenados em memória, sem uso de banco de dados.
  </p>

<h2>O que o sistema faz</h2>
  <ul>
    <li>Cadastra funcionários</li>
    <li>Remove funcionário por ID</li>
    <li>Aplica aumento salarial de 10%</li>
    <li>Agrupa funcionários por função</li>
    <li>Lista aniversariantes dos meses 10 e 12</li>
    <li>Mostra o funcionário mais velho e sua idade</li>
    <li>Ordena funcionários em ordem alfabética</li>
    <li>Calcula o total dos salários</li>
    <li>Mostra quantos salários mínimos cada funcionário recebe</li>
  </ul>


<h2>Estrutura</h2>
  <ul>
	<li><strong>model</strong> - classes de domínio</li>
    <li><strong>service</strong> - regras de negócio</li>
    <li><strong>util</strong> - formatação de datas e salários</li>
    <li><strong>Principal</strong> - ponto de execução da aplicação</li>
  </ul>

<h2>Como executar</h2>

<p><strong>Pré-requisitos:</strong></p>
<ul>
  <li>Java 25 instalado</li>
  <li>Maven instalado e configurado no PATH</li>
</ul>

<p>Passos para executar o programa:</p>

<ol>
  <li>Abra o terminal na pasta do projeto: gestao-funcionarios</li>
  <li>Execute o comando para gerar o build:</li>
</ol>

<pre>
mvn clean install
</pre>

<ol start="3">
  <li>Após o build, execute o programa com:</li>
</ol>

<pre>
java -jar target/gestao-funcionarios-1.0-SNAPSHOT.jar
</pre>

<h2>Autor</h2>
  <p>Alex Júnior</p>

</body>
</html>
