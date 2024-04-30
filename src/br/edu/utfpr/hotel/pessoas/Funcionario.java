public abstract class Funcionario {
    private String nome;
    private String cpf;
    private String telefone;
    private String cargo;
    private double salario;

    public Funcionario (String nome, String cpf, String telefone,
                        String cargo, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString () {
        return "Nome: " + nome +
                "CPF: " + cpf +
                "Telefone: " + telefone +
                "Cargo: " + cargo +
                "Salário: " + salario;
    }
}
