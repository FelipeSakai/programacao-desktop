package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.NotaFiscalDTO;
import br.unigran.entidades.NotaFiscal;
import br.unigran.persistencia.notaFiscal.NotaFiscalDao;
import br.unigran.persistencia.notaFiscal.NotaFiscalImpl;
import java.util.List;

public class NotaFiscalControl implements Controller {

    NotaFiscalDao dao = new NotaFiscalImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(((NotaFiscalDTO) dto).builder());
    }

    public void salvar(String[] notaFiscal) throws Exception {
        dao.salvar(builder(notaFiscal));
    }

    private NotaFiscal builder(String[] valores) throws Exception {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setCnpj(valores[0]);
        notaFiscal.setNome(valores[1]);
        return notaFiscal;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "CNPJ", "Nome", "Endereço", "Entrada", "Saída"};
    }

    @Override
    public Object[] getDados(DTO o) {
        NotaFiscalDTO dto = (NotaFiscalDTO) o;
        return new Object[]{dto.idNotaFiscal, dto.cnpjNotaFiscal, dto.nomeNotaFiscal, dto.enderecoNotaFiscal, dto.entradaNotaFiscal, dto.saidaNotaFiscal};
    }

    @Override
    public List<NotaFiscalDTO> getListaDados() {
        List<NotaFiscal> dados = dao.listar(NotaFiscal.class);
        NotaFiscalDTO notaFiscalDTO = new NotaFiscalDTO();
        return notaFiscalDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((NotaFiscalDTO) dto).builder());
    }
}
