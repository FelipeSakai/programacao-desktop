package br.unigran.persistencia.entrada;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;


public interface EntradaDao extends InterfaceDao{
    public  List listarbyNome(String nome);
    
}
