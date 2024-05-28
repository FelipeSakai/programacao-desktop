package br.unigran.persistencia.funcionario;

import br.unigran.entidades.Funcionario;
import br.unigran.persistencia.Dao;
import java.util.List;


public class FuncionarioImpl implements FuncionarioDao{
     @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from funcionario where nome like '% :? %'",Funcionario.class)
                .setParameter(1,nome).getResultList();
    }
    
}
