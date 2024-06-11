package br.unigran.dto;

import br.unigran.entidades.NotaFiscal;
import java.util.LinkedList;
import java.util.List;

public class NotaFiscalDTO extends DTO {
    public Integer idNotaFiscal;
    public String cnpjNotaFiscal;
    public String nomeNotaFiscal;
    public String enderecoNotaFiscal;
    public String entradaNotaFiscal;
    public String saidaNotaFiscal;

    @Override
    public NotaFiscal builder() {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setId(id != null ? Integer.valueOf(id) : null);
        notaFiscal.setCnpj(cnpjNotaFiscal);
        notaFiscal.setNome(nomeNotaFiscal);
        return notaFiscal;
    }

    public List<NotaFiscalDTO> getListaDados(List<NotaFiscal> dados) {
        List<NotaFiscalDTO> dadosDTO = new LinkedList<>();
        for (NotaFiscal dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }

    private NotaFiscalDTO converte(NotaFiscal notaFiscal) {
        NotaFiscalDTO dto = new NotaFiscalDTO();
        dto.id = notaFiscal.getId() != null ? notaFiscal.getId().toString() : null;
        dto.cnpjNotaFiscal = notaFiscal.getCnpj();
        dto.nomeNotaFiscal = notaFiscal.getNome();
        return dto;
    }
}
