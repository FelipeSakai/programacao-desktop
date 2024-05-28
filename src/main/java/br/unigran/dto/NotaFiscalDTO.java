package br.unigran.dto;

import br.unigran.entidades.Endereco;
import br.unigran.entidades.Entrada;
import br.unigran.entidades.NotaFiscal;
import br.unigran.entidades.Produtos;
import br.unigran.entidades.Saida;
import java.util.LinkedList;
import java.util.List;


public class NotaFiscalDTO extends DTO {
    public Integer idNotaFiscal;
    public String cnpjNotaFiscal;
    public String nomeNotaFiscal;
    public Endereco endereçoNotaFiscal;
    public Entrada entradaNotaFiscal;
    public Saida saidaNotaFiscal;
    
    @Override
    public NotaFiscal builder (){
        NotaFiscal notafiscal = new NotaFiscal();
        notafiscal.setId(id!=null?Integer.valueOf(id):01);
        notafiscal.setCnpj(id);
        notafiscal.setNome(nomeNotaFiscal);
        notafiscal.setEndereço(endereçoNotaFiscal);
        notafiscal.setEntrada(entradaNotaFiscal);
        notafiscal.setSaida(saidaNotaFiscal);
        
        return notafiscal;
    }
    public List getListaDados(List<NotaFiscal> dados) {
        List dadosDTO = new LinkedList();
        for (NotaFiscal dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }
    private Object converte (NotaFiscal f){
        NotaFiscalDTO dto = new NotaFiscalDTO();
        dto.id=f.getId().toString();
        dto.cnpjNotaFiscal=f.getCnpj();
        dto.nomeNotaFiscal=f.getNome();
        dto.endereçoNotaFiscal=f.getEndereço();
        dto.entradaNotaFiscal=f.getEntrada();
        dto.saidaNotaFiscal=f.getSaida();
        
        return dto;
    }
}
