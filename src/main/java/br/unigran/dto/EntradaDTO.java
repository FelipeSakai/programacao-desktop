package br.unigran.dto;

import br.unigran.entidades.Entrada;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EntradaDTO extends DTO {
    public Integer idEntrada;
    public Date dataEntradaEntrada;
    public String notaFiscalEntrada;
    public String SecaoEntrada;
    
    @Override
    public Entrada builder (){
        Entrada entrada = new Entrada();
        entrada.setId(id!=null?Integer.valueOf(id):01);
        entrada.setDataEntrada(dataEntradaEntrada);
        entrada.setNotaFiscal(notaFiscalEntrada);
        entrada.setSecao(SecaoEntrada);
        
        return entrada;
    }
    public List getListaDados(List<Entrada> dados) {
        List dadosDTO = new LinkedList();
        for (Entrada dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }
    private Object converte(Entrada f){
        EntradaDTO dto = new EntradaDTO();
        dto.id=f.getId().toString();
        dto.dataEntradaEntrada=f.getDataEntrada();
        dto.notaFiscalEntrada=f.getNotaFiscal();
        dto.SecaoEntrada=f.getSecao();
        
        return dto;
    }
}
