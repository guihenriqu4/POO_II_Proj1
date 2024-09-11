# CRUD Java

---

# Programação Orientada a Objetos II

## Desenvolvimento de um CRUD com Java, IntelliJ IDEA, Maven e PostgreSQL

### Author: Guilherme Silva (guihenriqu4); Date: 14/08/2024

# Sumário

1. [Configuração do Banco de Dados em Ubuntu](#configuração-do-banco-de-dados-em-ubuntu)
2. [Configuração do ambiente de desenvolvimento (Maeven)](#configuração-do-ambiente-de-desenvolvimento-maven)
3. [Configuração de Infraestrutura](#configuração-de-infraestrutura)

---

# Configuração do Banco de Dados(DB) em Ubuntu

---

Leva-se em consideração que o PostgreSQL tenha sido instalado pela dependência Maeven. Caso não esteja funcionado, siga o passo a passo de instalação presente em: [Instalação do PostgreSQL no Ubuntu](https://github.com/rogerio-silva/java-crud?tab=readme-ov-file#configura%C3%A7%C3%A3o-do-ambiente-de-desenvolvimento)

---

## Criação do Banco de Dados

Antes de qualquer ação, baixe o arquivo de script presente neste GitHub e armazene em um local cujo endereço possa ser facilmente lembrado.
Agora acesse o usuário postgres:

```shell
sudo su - postgres
```

Em seguida, acesse o prompt do psql:

```shell
psql
```

Ademais, crie um usuário com mesmo nome e senha de sua máquina com os seguintes comandos:

```shell
CREATE USER nome_do_usuario SUPERUSER INHERIT CREATEDB CREATEROLE;
```

```shell
ALTER USER nome_do_usuario PASSWORD 'senha';
```

Com essa etapa concluída, crie um DB (O nome do DB não precisa ser igual ao do arquivo de script, entretanto, deve ser IDÊNTICO ao nome do DB que originou o arquivo.sql). Isso pode ser feito de duas maneiras:

 - Via terminal Linux
```shell
createdb "nome_do_banco"
```

 - Via prompt psql
```shell
sudo su - postgres
psql
CREATE DATABASE "nome_do_banco";
```

Com o banco de dados criado, realize o restore de acordo com o tipo de arquivo do seu script.

 - .tar
```shell
pg_restore -U "nome_do_usuario" -W -d "nome_do_banco_criado" < "caminho/do/arquivo/nome_do_arquivo.tar"
```

 - .sql
```shell
psql -U "nome_do_usuario" -W -d "nome_do_banco_criado" < "caminho/do/arquivo/nome_do_arquivo.sql"
```

Para verificar se os dados foram importados corretamente, acesse o banco de dados e liste as tabelas:

```shell
sudo su - postgres
psql
\c "nome_do_banco"
\dt
```

## A saber

Para se criar o arquivo de script do DB é necessário realizar um dump. Há duas formas de realizar esse processo (a diferença entre eles é o tipo de arquivo gerado, que impactará no momento de restore):

 - .tar
```shell
pg_dump -U "nome_do_usuario" -W -F t "nome_do_banco" > "caminho/arquivo.tar"
```

 - .sql
```shell
pg_dump -U "nome_do_usuario" -W -F p "nome_do_banco" > "caminho/arquivo.sql"
```

---

# Configuração do ambiente de desenvolvimento (Maven)

## A ferramenta utilizada neste projeto será o IntelliJ IDEA

- Copie o link de cópia desse repositório Git (Aconselhável, nesse momento, utilizar o link http)

  ![green_bottom.png](img/green_bottom.png)

- Acesse a aba "Get from VCS" da ferrementa IntelliJ IDEA

  ![intelliJ#1](img/intelliJ_1.png)

- Cole o link copiado na região de url e selecione o endereço desejado. Por fim, clique em "clone"

  ![intelliJ#2](img/intelliJ_2.png)

- Preparações concluídas. Resta agora instalar as dependências Maeven e configurar a infraestrutura.

---

# Configuração de Infraestrutura

- Com o projeto instalado em seu computador, acesse o seguinte endereço src/main/java/br.com.numbersapp/infra/BancoDeDados.java

  ![intelliJ#3](img/intelliJ_3.png)

- Em seguida, altere os campos "user" e "password", inserindo o usuário e senha criados na primeira etapa deste documento

  ![intelliJ4](img/intelliJ_4.png)

- Encerrado esse processo, basta prosseguir com seus desejos no código. Boa sorte!