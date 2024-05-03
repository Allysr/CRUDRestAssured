package factory.Usuario;

import com.google.gson.Gson;
import utils.GeradorCPF;

public class UsuarioData {

    public String userJson(UsuarioFactory usuarioData){
        Gson gson = new Gson();
        return gson.toJson(usuarioData);
    }

    public String novoUsuario (){
        GeradorCPF cpf = new GeradorCPF();
        UsuarioFactory ana = new UsuarioFactory("Ana", "11/11/1970", cpf.gerarCPF());
        return userJson(ana);
    }

    public String usuarioVazio(){
        UsuarioFactory ana = new UsuarioFactory("", "", "");
        return userJson(ana);
    }

    public String usuarioCPFInvalido(){
        UsuarioFactory ana = new UsuarioFactory("Ana", "11/11/1970", "0000000");
        return userJson(ana);
    }

    public String usuarioCPFExistente(){
        UsuarioFactory cpfExistente = new UsuarioFactory("Ana", "11/11/1970", "149.408.830-43");
        return userJson(cpfExistente);
    }

}

