package br.unigran.persistencia.saida;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;


public interface SaidaDao extends InterfaceDao {
    public  List listarbyNome(String nome);
    
}
