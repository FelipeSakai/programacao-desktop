package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.LoginDTO;
import br.unigran.entidades.Login;
import br.unigran.persistencia.login.LoginDao;
import br.unigran.persistencia.login.LoginImpl;
import java.util.List;

public class LoginControl implements Controller {

    LoginDao dao = new LoginImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(dto.builder());
    }

    public void salvar(String[] login) throws Exception {
        dao.salvar(builder(login));
    }

    private Login builder(String[] valores) throws Exception {
        Login login = new Login();
        login.setLogin(valores[0]);
        login.setSenha(valores[1]);
        return login;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "Login", "Senha"};
    }

    @Override
    public Object[] getDados(DTO o) {
        LoginDTO dto = (LoginDTO) o;
        return new Object[]{dto.id, dto.login, dto.senha};
    }

    @Override
    public List getListaDados() {
        List<Login> dados = dao.listar(Login.class);
        LoginDTO loginDTO = new LoginDTO();
        return loginDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((LoginDTO) dto).builder());
    }
}
