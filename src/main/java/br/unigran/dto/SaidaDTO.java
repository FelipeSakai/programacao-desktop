package br.unigran.dto;

import br.unigran.entidades.Saida;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SaidaDTO extends DTO {
    public Integer idSaida;
    public String motivoSaida;
    public Date dtSaida;

    @Override
    public Saida builder() {
        Saida saida = new Saida();
        saida.setId(id != null ? Integer.valueOf(id) : null);
        saida.setMotivo(motivoSaida);
        saida.setDtSaida(dtSaida);
        return saida;
    }

    public List<SaidaDTO> getListaDados(List<Saida> dados) {
        List<SaidaDTO> dadosDTO = new LinkedList<>();
        for (Saida dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }

    private SaidaDTO converte(Saida saida) {
        SaidaDTO dto = new SaidaDTO();
        dto.id = saida.getId() != null ? saida.getId().toString() : null;
        dto.idSaida = saida.getId();
        dto.motivoSaida = saida.getMotivo();
        dto.dtSaida = saida.getDtSaida();
        return dto;
    }
}