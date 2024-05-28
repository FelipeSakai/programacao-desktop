package br.unigran.persistencia.funcionario;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;


public interface FuncionarioDao extends InterfaceDao{
    public  List listarbyNome(String nome);
    
}
