package DTO;

public final class UsuarioDTO {
    private int id;

    private String cpf;

    private String nome;

    private String senha;

    private UsuarioDTO(int id, String cpf, String nome, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioDTOBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UsuarioDTOBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public UsuarioDTOBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioDTOBuilder setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioDTO build() {
        return new UsuarioDTO(id, cpf, nome, senha);
    }
}