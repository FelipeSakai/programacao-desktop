package br.unigran.persistencia.entrada;

import br.unigran.entidades.Entrada;
import br.unigran.persistencia.Dao;
import java.util.List;


public class EntradaImpl implements EntradaDao{
   
    @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from entrada where nome like '% :? %'",Entrada.class)
                .setParameter(1,nome).getResultList();
    }
}
