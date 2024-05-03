package factory.Usuario;


public class UsuarioFactory {
    private String nome;
    private String dataNascimento;
    private String cpf;

    public UsuarioFactory(String nome, String dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}


