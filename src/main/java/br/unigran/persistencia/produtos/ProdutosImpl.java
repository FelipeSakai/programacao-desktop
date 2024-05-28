package br.unigran.persistencia.produtos;

import br.unigran.entidades.Produtos;
import br.unigran.persistencia.Dao;
import java.util.List;


public class ProdutosImpl implements ProdutosDao{
    
    @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from produtos where nome like '% :? %'",Produtos.class)
                .setParameter(1,nome).getResultList();
    }
    
}
