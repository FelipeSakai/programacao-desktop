package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.EntradaDTO;
import br.unigran.entidades.Entrada;
import br.unigran.persistencia.entrada.EntradaDao;
import br.unigran.persistencia.entrada.EntradaImpl;
import java.util.List;

public class EntradaControl implements Controller {

    EntradaDao dao = new EntradaImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(dto.builder());
    }

    public void salvar(String[] entrada) throws Exception {
        dao.salvar(builder(entrada));
    }

    private Entrada builder(String[] valores) throws Exception {
        Entrada entrada = new Entrada();
        entrada.setDataEntrada(java.sql.Date.valueOf(valores[0]));
        entrada.setNotaFiscal(valores[1]);
        entrada.setSecao(valores[2]);
        return entrada;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "Data de Entrada", "Nota Fiscal", "Seção"};
    }

    @Override
    public Object[] getDados(DTO o) {
        EntradaDTO dto = (EntradaDTO) o;
        return new Object[]{dto.id, dto.dataEntrada, dto.notaFiscal, dto.secao};
    }

    @Override
    public List getListaDados() {
        List<Entrada> dados = dao.listar(Entrada.class);
        EntradaDTO entradaDTO = new EntradaDTO();
        return entradaDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((EntradaDTO) dto).builder());
    }
}
