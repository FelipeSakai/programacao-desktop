package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.NotaFiscalDTO;
import br.unigran.entidades.NotaFiscal;
import br.unigran.persistencia.notafiscal.NotaFiscalDao;
import br.unigran.persistencia.notafiscal.NotaFiscalImpl;
import java.util.List;

public class NotaFiscalControl implements Controller {

    NotaFiscalDao dao = new NotaFiscalImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(dto.builder());
    }

    public void salvar(String[] notaFiscal) throws Exception {
        dao.salvar(builder(notaFiscal));
    }

    private NotaFiscal builder(String[] valores) throws Exception {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setCnpj(valores[0]);
        return notaFiscal;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "CNPJ", "Endereço", "Entrada", "Saída"};
    }

    @Override
    public Object[] getDados(DTO o) {
        NotaFiscalDTO dto = (NotaFiscalDTO) o;
        return new Object[]{dto.id, dto.cnpj, dto.endereco, dto.entrada, dto.saida};
    }

    @Override
    public List getListaDados() {
        List<NotaFiscal> dados = dao.listar(NotaFiscal.class);
        NotaFiscalDTO notaFiscalDTO = new NotaFiscalDTO();
        return notaFiscalDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((NotaFiscalDTO) dto).builder());
    }
}
