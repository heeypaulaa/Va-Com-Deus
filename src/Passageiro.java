import java.util.Date;

public class Passageiro {

    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private Date dataNascimento;
    private int numeroVoo;

    public Passageiro(String nome, String telefone, String email, String cpf,
                      Date dataNascimento, int numeroVoo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.setNumeroVoo(numeroVoo);
    }

    public Passageiro() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    @Override
    public String toString() {
        return "Passageiro [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf
                + ", dataNascimento=" + dataNascimento + ", numeroVoo=" + numeroVoo + "]";
    }


}