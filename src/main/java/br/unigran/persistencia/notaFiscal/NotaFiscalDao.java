package br.unigran.persistencia.notaFiscal;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;


public interface NotaFiscalDao extends InterfaceDao{
    public  List listarbyNome(String nome);
}
