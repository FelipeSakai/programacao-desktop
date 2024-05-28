package br.unigran.persistencia.login;

import br.unigran.entidades.Login;
import br.unigran.persistencia.Dao;
import java.util.List;


public class LoginImpl implements LoginDao {
    
    @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from login where nome like '% :? %'",Login.class)
                .setParameter(1,nome).getResultList();
    
    }
}
