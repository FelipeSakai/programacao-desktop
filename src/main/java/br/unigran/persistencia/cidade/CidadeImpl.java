package br.unigran.persistencia.cidade;

import br.unigran.entidades.Cidade;
import br.unigran.persistencia.Dao;
import java.util.List;


public class CidadeImpl implements CidadeDao{
    @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from cidade where nome like '% :? %'",Cidade.class)
                .setParameter(1,nome).getResultList();
        }
}
