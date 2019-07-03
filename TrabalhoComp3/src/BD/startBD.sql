CREATE TABLE Usuario(
    id INTEGER PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START with 1, INCREMENT BY 1),

    cpf VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
)



CREATE TABLE Visitante(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Usuario(id)
)



CREATE TABLE Administrador(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Usuario(id)
)



CREATE TABLE Funcionario(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Usuario(id)
)



CREATE TABLE Gestor(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Funcionario(id)
)



CREATE TABLE Curador(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Funcionario(id)
)



CREATE TABLE Expositor(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Funcionario(id)
)



CREATE TABLE Obra(
    id INTEGER PRIMARY KEY
)



CREATE TABLE Objeto(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Obra(id)
)



CREATE TABLE Musica(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Obra(id)
)



CREATE TABLE Estatua(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Obra(id)
)



CREATE TABLE Quadro(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Obra(id)
)



CREATE TABLE Pintura(
    id INTEGER PRIMARY KEY,

    FOREIGN KEY (id)
    REFERENCES Obra(id)
)



CREATE TABLE Avaliacao(
    id INTEGER PRIMARY KEY,
    usuarioId INTEGER NOT NULL,

    FOREIGN KEY (usuarioId)
    REFERENCES Usuario(id)
)



CREATE TABLE Museu(
    id INTEGER PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START with 1, INCREMENT BY 1),

    nome VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    dataCriacao DATE NOT NULL,
    idGestor INTEGER NOT NULL,

    FOREIGN KEY (idGestor)
    REFERENCES Gestor(id)
)



CREATE TABLE AvaliacaoMuseu(
    id INTEGER PRIMARY KEY,
    avaliacaoId INTEGER NOT NULL,
    museuId INTEGER NOT NULL,

    FOREIGN KEY (avaliacaoId)
    REFERENCES Avaliacao(id),

    FOREIGN KEY (museuId)
    REFERENCES Museu(id)
)



CREATE TABLE Solicitacao(
    id INTEGER PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START with 1, INCREMENT BY 1),

    nome VARCHAR(255) NOT NULL,
    dataCriacao VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cpfGestor VARCHAR(255) NOT NULL,
    nomeGestor VARCHAR(255) NOT NULL,
    senhaGestor VARCHAR(255) NOT NULL
)



CREATE TABLE Acervo(
    id INTEGER PRIMARY KEY,
    idCurador INTEGER NOT NULL,
    idMuseu INTEGER,

    FOREIGN KEY (idCurador)
    REFERENCES Curador(id)
)



CREATE TABLE AvaliacaoAcervo(
    id INTEGER PRIMARY KEY,
    avaliacaoId INTEGER NOT NULL,
    acervoId INTEGER NOT NULL,

    FOREIGN KEY (avaliacaoId)
    REFERENCES Avaliacao(id),

    FOREIGN KEY (acervoId)
    REFERENCES Acervo(id)
)



CREATE TABLE Exposicao(
    id INTEGER PRIMARY KEY,
    idExpositor INTEGER NOT NULL,

    FOREIGN KEY (idExpositor)
    REFERENCES Expositor(id)
)



CREATE TABLE AlocacaoExposicao(
    id INTEGER PRIMARY KEY,
    idAcervo INTEGER NOT NULL,
    idExposicao INTEGER,

    FOREIGN KEY (idAcervo)
    REFERENCES Acervo(id),

    FOREIGN KEY (idExposicao)
    REFERENCES Exposicao(id)
)



CREATE TABLE AlocacaoAcervo(
    id INTEGER PRIMARY KEY,
    idAcervo INTEGER NOT NULL,
    idObra INTEGER,

    FOREIGN KEY (idAcervo)
    REFERENCES Acervo(id),

    FOREIGN KEY (idObra)
    REFERENCES Obra(id)
)



CREATE TABLE AvaliacaoExposicao(
    id INTEGER PRIMARY KEY,
    avaliacaoId INTEGER NOT NULL,
    exposicaoId INTEGER NOT NULL,

    FOREIGN KEY (avaliacaoId)
    REFERENCES Avaliacao(id),

    FOREIGN KEY (exposicaoId)
    REFERENCES Exposicao(id)
)



CREATE TABLE AvaliacaoObra(
    id INTEGER PRIMARY KEY,
    avaliacaoId INTEGER NOT NULL,
    obraId INTEGER NOT NULL,

    FOREIGN KEY (avaliacaoId)
    REFERENCES Avaliacao(id),

    FOREIGN KEY (obraId)
    REFERENCES Obra(id)
)