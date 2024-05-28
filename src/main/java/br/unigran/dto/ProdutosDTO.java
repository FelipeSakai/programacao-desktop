package br.unigran.dto;

import br.unigran.entidades.Produtos;
import java.util.LinkedList;
import java.util.List;



public class ProdutosDTO extends DTO {
    public Integer idProduto;
    public double codProduto;
    public String fornecedorProduto;
    public String categoriaProduto;
    public double valorVendaProduto;
    public double valorCompraProduto;
    public double quantidadeProduto;
    public int minQuantidadeProduto;
    
    @Override
    public Produtos builder (){
        Produtos produtos = new Produtos();
        produtos.setId(id!=null?Integer.valueOf(id):01);
        produtos.setCodProd(codProduto);
        produtos.setFornecedor(fornecedorProduto);
        produtos.setCategoria(categoriaProduto);
        produtos.setValorVenda(valorVendaProduto);
        produtos.setValorCompra(valorCompraProduto);
        produtos.setQuantidade(quantidadeProduto);
        produtos.setMinQuantidade(minQuantidadeProduto);
        
        return produtos;
    }
    
    public List getListaDados(List<Produtos> dados) {
        List dadosDTO = new LinkedList();
        for (Produtos dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }
    private Object converte(Produtos f){
        ProdutosDTO dto= new ProdutosDTO();
        dto.id=f.getId().toString();
        dto.codProduto=f.getCodProd();
        dto.fornecedorProduto=f.getFornecedor();
        dto.categoriaProduto=f.getCategoria();
        dto.valorVendaProduto=f.getValorVenda();
        dto.valorCompraProduto=f.getValorCompra();
        dto.quantidadeProduto=f.getQuantidade();
        dto.minQuantidadeProduto=f.getMinQuantidade();
        
        return dto;
    }
}
