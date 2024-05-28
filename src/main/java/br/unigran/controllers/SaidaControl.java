package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.SaidaDTO;
import br.unigran.entidades.Saida;
import br.unigran.persistencia.saida.SaidaDao;
import br.unigran.persistencia.saida.SaidaImpl;
import java.util.List;

public class SaidaControl implements Controller {

    SaidaDao dao = new SaidaImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(dto.builder());
    }

    public void salvar(String[] saida) throws Exception {
        dao.salvar(builder(saida));
    }

    private Saida builder(String[] valores) throws Exception {
        Saida saida = new Saida();
        saida.setMotivo(valores[0]);
        // Supondo que os valores[1] seja a data de saída no formato "yyyy-MM-dd"
        saida.setDtSaida(java.sql.Date.valueOf(valores[1]));
        return saida;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "Motivo", "Data de Saída"};
    }

    @Override
    public Object[] getDados(DTO o) {
        SaidaDTO dto = (SaidaDTO) o;
        return new Object[]{dto.id, dto.motivo, dto.dtSaida};
    }

    @Override
    public List getListaDados() {
        List<Saida> dados = dao.listar(Saida.class);
        SaidaDTO saidaDTO = new SaidaDTO();
        return saidaDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((SaidaDTO) dto).builder());
    }
}
