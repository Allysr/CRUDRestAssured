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
        UsuarioFactory usuario = new UsuarioFactory();
        usuario.setNome("Ana");
        usuario.setDataNascimento("10/10/1975");
        usuario.setCpf(cpf.gerarCPF());
        return userJson(usuario);
    }

    public String usuarioVazio(){
        UsuarioFactory usuario = new UsuarioFactory();
        usuario.setNome("");
        usuario.setDataNascimento("");
        usuario.setCpf("");
        return userJson(usuario);
    }

    public String usuarioCPFInvalido(){
        UsuarioFactory usuario = new UsuarioFactory();
        usuario.setNome("Ana");
        usuario.setDataNascimento("10/10/1975");
        usuario.setCpf("000");
        return userJson(usuario);
    }

    public String usuarioCPFExistente(String cpf){
        UsuarioFactory usuario = new UsuarioFactory();
        usuario.setNome("Ana");
        usuario.setDataNascimento("10/10/1975");
        usuario.setCpf(cpf);
        return userJson(usuario);
    }

}


