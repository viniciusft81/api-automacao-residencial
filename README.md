# Projeto Prático 2 - Implementação da API RESTful de uma Central de Automação Residencial

## Vinicius Figueiró Tonini

> Esse repositório contém a resolução do segundo projeto prático da disciplina de Sistemas Distribuídos (STD29006).

<!--ts-->
   * [Projeto Proposto](#Projeto-Proposto)
   * [Funcionalidades Implementadas](#Funcionalidades-Implementadas)  
   * [Executando o Projeto](#Executando-o-Projeto)
   * [Consumindo o Serviço com o Curl](#Consumindo-o-Serviço-com-o-Curl)
   * [Documentação](#Documentação)
<!--te-->

### Projeto Proposto
A API modelada de um Serviço Web RESTful é voltada para uma central de automação residencial que deve permitir aplicações desenvolvidas por terceiros interagir com essa central para controlar os dispositivos inteligentes associados à esta. 

A central de automação residencial possibilita controlar diversos dispositivos inteligentes de uma residência, tais como: lâmpadas, TV, sistema de som, ar condicionado, cortinas, portões eletrônicos, etc. Por meio da API RESTful o usuário pode agrupar os dispositivos em ambientes (i.e. sala, quarto, etc.), definir cenários que deseja o funcionamento dos dispositivos (i.e. fim de semana, amanhecer durante semana, etc.) e interagir diretamente com os dispositivos (i.e. ligar, desligar, ver a temperatura atual, volume atual, etc.). Para mais informações consulte o arquivo do [Projeto](std-projeto-pratico-02.pdf).

### Funcionalidades Implementadas

- [x] Implementação desenvolvida em Java
- [x] Documentação com OpenAPI
- [x] Agrupar dispositivos em ambientes
- [x] Definir cenários
- [x] Interagir diretamente com os dispositivos

### Executando o Projeto
Após realizar o clone do repositório e estar no diretório raiz do mesmo, o seguinte comando deve ser executado:

```bash
./gradlew bootRun
```
Se tudo der certo, o servidor `spring boot` estará rodando, com isso, é possível consumir o serviço com `curl` em um terminal. O servidor estará rodando no endereço http://localhost:8080/

### Consumindo o Serviço com o Curl
Abaixo está disponível os comando `curl` para consumir os serviços da API RESTful,
em que é possível utilizar os métodos `GET`, `POST`, `PUT` e `DELETE`. 


### Dispositivos

- Obter detalhes dos dispositivos
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos' -H 'accept: application/json'
```
- Obter detalhes de um dispositivo
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/4' -H 'accept: application/json'
```
- Obter detalhes das lâmpadas
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/lampadas' -H 'accept: application/json'
```
- Obter detalhes de uma lâmpada
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/lampadas/1' -H 'accept: application/json'
``` 
- Interagir com uma lâmpada
```shell
curl -X 'PUT' 'http://localhost:8080/dispositivos/lampadas/1' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "lampada ao amanhecer","ligado": true,"intensidade": 4,"cor": "azul"}'
```
- Obter detalhes das tvs
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/tv' -H 'accept: application/json'
```
- Obter detalhes de uma única tv
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/tv/3' -H 'accept: application/json'
```
- Interagir com a tv
```shell
curl -X 'PUT' 'http://localhost:8080/dispositivos/tv/3' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "tv grande","ligado": true,"canal": 9,"volume": 25}'
```
- Obter detalhes dos sistemas de som
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/sistemaSom' -H 'accept: application/json'
```
- Obter detalhes de um único sistema de som
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/sistemaSom/4' -H 'accept: application/json'
```
- Interagir com o sistema de som
```shell
curl -X 'PUT' 'http://localhost:8080/dispositivos/sistemaSom/4' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "som ambiente","ligado":true,"volume": 20}'
```
- Obter detalhes dos ar condicionados
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/arCondicionado' -H 'accept: application/json'
```
- Obter detalhes de um único ar condicionado
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/arCondicionado/6' -H 'accept: application/json'
```
- Interagir com o ar condicionado
```shell
curl -X 'PUT' 'http://localhost:8080/dispositivos/arCondicionado/6' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "ar gelar","ligado":true,
"temperatura": 17}'
```
- Obter detalhes das cortinas
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/cortinas' -H 'accept: application/json'
```
- Obter detalhes de uma única cortina
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/cortinas/8' -H 'accept: application/json'
```
- Interagir com a cortina
```shell
curl -X 'PUT' 'http://localhost:8080/dispositivos/cortinas/8' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "cortina grande","aberto": true}'
```
- Obter detalhes dos portões
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/portoes' -H 'accept: application/json'
```
- Obter detalhes de um único portão
```shell
curl -X 'GET' 'http://localhost:8080/dispositivos/portoes/11' -H 'accept: application/json'
```
- Interagir com o portão
```shell
curl -X 'PUT' 'http://localhost:8080/dispositivos/portoes/11' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "portao da garagem","aberto": true}'
```

### Ambientes

- Adicionar ambiente
```shell
curl -X 'POST' 'http://localhost:8080/ambientes' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "sala"}'
```
- Obter ambientes cadastrado
```shell
curl -X 'GET' 'http://localhost:8080/ambientes' -H 'accept: application/json'
```
- Adicionar dispositivos no ambiente
```shell
curl -X 'POST' 'http://localhost:8080/ambientes/1/dispositivos?id=4' -H 'accept: application/json' -d ''
```
- Adicionar outro dispositivo
```shell
curl -X 'POST' 'http://localhost:8080/ambientes/1/dispositivos?id=3' -H 'accept: application/json' -d ''
```
- Obter detalhes do ambiente
```shell
curl -X 'GET' 'http://localhost:8080/ambientes/1' -H 'accept: application/json'
```
- Alterar nome do ambiente
```shell
curl -X 'PUT' 'http://localhost:8080/ambientes/1?nome=quarto' -H 'accept: application/json'
```
- Deletar dispositivo do ambiente
```shell
curl -X 'DELETE' 'http://localhost:8080/ambientes/1/dispositivos?id=3' -H 'accept: */*'
```
- Deletar um ambiente
```shell
curl -X 'DELETE' 'http://localhost:8080/ambientes/1' -H 'accept: */*'
```
- Obter ambientes cadastrado
```shell
curl -X 'GET' 'http://localhost:8080/ambientes' -H 'accept: application/json'
```

### Cenários

- Adicionar um cenário
```shell
curl -X 'POST' 'http://localhost:8080/cenarios' -H 'accept: */*' -H 'Content-Type: application/json' -d '{"nome": "amanhecer","inicio": "7:00","fim":"8:00"}'
```
- Adicionar outro cenário
```shell
curl -X 'POST' 'http://localhost:8080/cenarios' -H 'accept: */*' -H 'Content-Type: application/json' -d '{ "nome": "fim de semana", "inicio": "sexta", "fim": "sabado"}'
```
- Adicionar um dispositivo no cenário criado
```shell
curl -X 'POST' 'http://localhost:8080/cenarios/amanhecer/dispositivos?id=1' -H 'accept: application/json' -d ''
```
- Obter lista de todos os cenários
```shell
curl -X 'GET' 'http://localhost:8080/cenarios' -H 'accept: application/json'
```
- Obter detalhes de um cenário específico
```shell
curl -X 'GET' 'http://localhost:8080/cenarios/amanhecer' -H 'accept: application/json'
```
- Altera dados de um cenário
```shell
curl -X 'PUT' 'http://localhost:8080/cenarios/amanhecer?nome=anoitecer&inicio=20&fim=21' -H 'accept:application/json'
```
- Deletar um dispositivo do cenário
```shell
curl -X 'DELETE' 'http://localhost:8080/cenarios/anoitecer/dispositivos?id=1' -H 'accept: */*'
```
- Deletar um cenário
```shell
curl -X 'DELETE' 'http://localhost:8080/cenarios/anoitecer' -H 'accept: */*'
```
- Obter lista de todos os cenários
```shell
curl -X 'GET' 'http://localhost:8080/cenarios' -H 'accept: application/json'
```

### Documentação

[Essa API foi documentada](https://oai.github.io/Documentation/specification-servers.html) de acordo com a especificação OpenAPI e a mesma pode ser visualizada em [OpenAPI](https://oai.github.io/Documentation/). O código fonte dessa documentação está disponível no arquivo [api-automacao.yaml](api-automacao.yaml) nesse repositório.

