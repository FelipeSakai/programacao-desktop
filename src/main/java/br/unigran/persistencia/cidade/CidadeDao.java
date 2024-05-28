package br.unigran.persistencia.cidade;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;


public interface CidadeDao extends InterfaceDao{
    public  List listarbyNome(String nome);
    
}
