package br.unigran.persistencia.saida;

import br.unigran.entidades.Saida;
import br.unigran.persistencia.Dao;
import java.util.List;


public class SaidaImpl implements SaidaDao{
    
    @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from saida where nome like '% :? %'",Saida.class)
                .setParameter(1,nome).getResultList();
    }
}
