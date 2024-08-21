CREATE TABLE IF NOT EXISTS Cliente(
    id_cliente serial not null,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    senha varchar(255) not null,
    PRIMARY KEY (id_cliente)
);

CREATE TABLE IF NOT EXISTSColaborador(
    id_colaborador serial not null,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    cargo varchar(255) not null,
    PRIMARY KEY (id_colaborador)
);

CREATE TABLE IF NOT EXISTS Estacao(
    id_estacao serial not null,
    nome varchar(255) not null,
    PRIMARY KEY (id_estacao, nome)
);

CREATE TABLE IF NOT EXISTS Produto(
    id_produto serial not null,
    nome varchar(255) not null,
    marca varchar(255) not null,
    descricao varchar(255),
    PRIMARY KEY (id_produto)
);

CREATE TABLE IF NOT EXISTS Servico(
    id_servico serial not null,
    nome varchar(255) not null,
    descricao varchar(255) not null,
    valor float not null,
    disponibilidade varchar(255) not null,
    PRIMARY KEY (id_servico)
);

CREATE TABLE IF NOT EXISTS Horario(
    dat varchar(10) not null,
    hora varchar(5) not null,
    PRIMARY KEY (dat, hora)
);

CREATE TABLE IF NOT EXISTS Estoque(
    id_produto bigint not null,
    quantidade int not null,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
);

CREATE TABLE IF NOT EXISTS Escala(
    dat varchar(10) not null,
    hora varchar(5) not null,
    id_colaborador bigint not null,
    id_estacao bigint not null,
    PRIMARY KEY (dat, hora, id_colaborador, id_estacao),
    FOREIGN KEY (dat, hora) REFERENCES Horario(dat, hora),
    FOREIGN KEY (id_colaborador) REFERENCES Colaborador(id_colaborador),
    FOREIGN KEY (id_estacao) REFERENCES Estacao(id_estacao)
);

CREATE TABLE IF NOT EXISTS Atendimento(
    dat varchar(10) not null,
    hora varchar(5) not null,
    id_colaborador bigint not null,
    id_estacao bigint not null,
    id_cliente bigint not null,
    id_servico bigint not null,
    PRIMARY KEY (dat, hora, id_colaborador, id_estacao, id_cliente, id_servico),
    FOREIGN KEY (dat, hora) REFERENCES Horario(dat, hora),
    FOREIGN KEY (id_colaborador) REFERENCES Colaborador(id_colaborador),
    FOREIGN KEY (id_estacao) REFERENCES Estacao(id_estacao),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_servico) REFERENCES Servico(id_servico)
);

CREATE TABLE IF NOT EXISTS Tel_cliente(
    id_cliente bigint not null,
    numero varchar(11) not null,
    PRIMARY KEY (id_cliente, numero),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE IF NOT EXISTS Tel_colaborador(
    id_colaborador bigint not null,
    numero varchar(11) not null,
    PRIMARY KEY (id_colaborador, numero),
    FOREIGN KEY (id_colaborador) REFERENCES Colaborador(id_colaborador)
);

CREATE TABLE IF NOT EXISTS temp_servico(
    id_servico bigint not null,
    hora varchar(2) not null,
    minuto varchar(2) not null,
    PRIMARY KEY (id_servico),
    FOREIGN KEY (id_servico) REFERENCES Servico(id_servico)
);

CREATE TABLE IF NOT EXISTS ServProd(
    id_servico bigint not null,
    id_produto bigint not null,
    PRIMARY KEY (id_servico, id_produto),
    FOREIGN KEY (id_servico) REFERENCES Servico(id_servico),
    FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
);
