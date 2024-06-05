package br.edu.utfpr.hotel.modelo;

public class Pessoa {

    private final Builder builder;

    public Pessoa(Builder builder) {
        this.builder = builder;
    }

    public String getNome() {
        return builder.nome;
    }

    public void setNome(String nome) {
        builder.nome = nome;
    }

    public String getEmail() {
        return builder.email;
    }

    public void setEmail(String email) {
        builder.email = email;
    }

    public String getTelefone() {
        return builder.telefone;
    }

    public void setTelefone(String telefone) {
        builder.telefone = telefone;
    }

    public String getEndereco() {
        return builder.endereco;
    }

    public void setEndereco(String endereco) {
        this.builder.endereco = endereco;
    }

    public static class Builder {

        private String nome;

        private String email;
        private String telefone;
        private String endereco;

        public Builder(String nome){
            this.nome = nome;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Pessoa build(){
            return new Pessoa(this);
        }

    }
}