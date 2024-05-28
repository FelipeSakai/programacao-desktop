/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.persistencia.notaFiscal;

import br.unigran.entidades.NotaFiscal;
import br.unigran.persistencia.Dao;
import java.util.List;

/**
 *
 * @author Suporte-OM
 */
public class NotaFiscalImpl implements NotaFiscalDao{
    
    @Override
    public List listarbyNome(String nome) {
        return Dao.getInstace().getEm().createNativeQuery(
                 "select * from notaFiscal where nome like '% :? %'",NotaFiscal.class)
                .setParameter(1,nome).getResultList();
    }
    
}
