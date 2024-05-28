/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unigran.persistencia.produtos;

import br.unigran.persistencia.InterfaceDao;
import java.util.List;

/**
 *
 * @author Suporte-OM
 */
public interface ProdutosDao extends InterfaceDao {
    public  List listarbyNome(String nome);
    
}
