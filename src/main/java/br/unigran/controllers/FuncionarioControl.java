/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.FuncionarioDTO;
import br.unigran.entidades.Funcionario;
import br.unigran.persistencia.funcionario.FuncionarioDao;
import br.unigran.persistencia.funcionario.FuncionarioImpl;
import java.util.List;

/**
 *
 * @author Suporte-OM
 */

   public class FuncionarioControl implements Controller {

    FuncionarioDao dao = new FuncionarioImpl();

    
    @Override
    public void salvar(DTO dto)  {

        dao.atualiza(dto.builder());

    }

    public void salvar(String[] func) throws Exception {

        dao.salvar(builder(func));

    }

    private Funcionario builder(String[] valores) throws Exception {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(valores[0]);

        if (funcionario.getNome() == null) {
            throw new Exception("Nome invalido");
        }
        return funcionario;

    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "Nome"};
    }

    @Override
    public Object[] getDados(DTO o) {
        FuncionarioDTO dto = (FuncionarioDTO) o;
        return new Object[]{dto.id, dto.nomeFuncionario};
    }

    @Override
    public List getListaDados() {
        List<Funcionario> dados = dao.listar(Funcionario.class);
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        return funcionarioDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((FuncionarioDTO) dto).builder());
    }
}