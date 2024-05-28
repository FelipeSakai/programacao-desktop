package br.unigran.persistencia.login;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;


public interface LoginDao extends InterfaceDao{
    public  List listarbyNome(String nome);
    
}
