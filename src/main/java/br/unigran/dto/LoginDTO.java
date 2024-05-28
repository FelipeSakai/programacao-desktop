package br.unigran.dto;

import br.unigran.entidades.Login;
import br.unigran.entidades.Produtos;
import java.util.LinkedList;
import java.util.List;


public class LoginDTO extends DTO{
    public Integer idLogin;
    public String loginLogin;
    public String senhaLogin;
    
    @Override
    public Login builder(){
        Login login = new Login ();
        login.setId(id!=null?Integer.valueOf(id):01);
        login.setLogin(loginLogin);
        login.setSenha(senhaLogin);
        
        return login;
    }
    public List getListaDados(List<Login> dados) {
        List dadosDTO = new LinkedList();
        for (Login dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }
    private Object converte (Login f){
        LoginDTO dto = new LoginDTO();
        dto.id=f.getId().toString();
        dto.loginLogin=f.getLogin();
        dto.senhaLogin=f.getSenha();
        
        return dto;
    }
}
