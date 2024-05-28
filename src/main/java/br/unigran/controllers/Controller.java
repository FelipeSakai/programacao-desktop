package br.unigran.controllers;

import br.unigran.dto.DTO;
import java.util.List;


public interface Controller {

    public String[] getTitulosColunas();//colunas matriz

    public Object[] getDados(DTO dto);//array matriz

    public List getListaDados();//lista de dados 

    public void remover(DTO dto);

    public void salvar(DTO dto) throws Exception;

}
