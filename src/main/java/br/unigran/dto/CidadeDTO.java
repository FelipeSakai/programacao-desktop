package br.unigran.dto;

import br.unigran.entidades.Cidade;
import java.util.LinkedList;
import java.util.List;

public class CidadeDTO extends DTO {
    public Long idCidade;
    public String nomeCidade;

    @Override
    public Cidade builder() {
        Cidade cidade = new Cidade();
        cidade.setId(id != null ? Long.valueOf(id) : null);
        cidade.setNome(nomeCidade);
        return cidade;
    }

    public List<CidadeDTO> getListaDados(List<Cidade> dados) {
        List<CidadeDTO> dadosDTO = new LinkedList<>();
        for (Cidade dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }

    private CidadeDTO converte(Cidade cidade) {
        CidadeDTO dto = new CidadeDTO();
        dto.id = cidade.getId() != null ? cidade.getId().toString() : null;
        dto.idCidade = cidade.getId();
        dto.nomeCidade = cidade.getNome();
        return dto;
    }
}