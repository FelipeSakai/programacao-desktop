package br.unigran.controllers;

import br.unigran.dto.DTO;
import br.unigran.dto.ProdutosDTO;
import br.unigran.entidades.Produtos;
import br.unigran.persistencia.produtos.ProdutosDao;
import br.unigran.persistencia.produtos.ProdutosImpl;
import java.util.List;

public class ProdutosControl implements Controller {

    ProdutosDao dao = new ProdutosImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(dto.builder());
    }

    public void salvar(String[] prod) throws Exception {
        dao.salvar(builder(prod));
    }

    private Produtos builder(String[] valores) throws Exception {
        Produtos produto = new Produtos();
        produto.setCodProd(Double.parseDouble(valores[0]));
        produto.setFornecedor(valores[1]);
        produto.setCategoria(valores[2]);
        produto.setValorVenda(Double.parseDouble(valores[3]));
        produto.setValorCompra(Double.parseDouble(valores[4]));
        produto.setQuantidade(Double.parseDouble(valores[5]));
        produto.setMinQuantidade(Integer.parseInt(valores[6]));
        return produto;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "Código do Produto", "Fornecedor", "Categoria", "Valor de Venda", "Valor de Compra", "Quantidade", "Quantidade Mínima"};
    }

    @Override
    public Object[] getDados(DTO o) {
        ProdutosDTO dto = (ProdutosDTO) o;
        return new Object[]{dto.idProduto, dto.codProduto, dto.fornecedorProduto, dto.categoriaProduto, dto.valorVendaProduto, dto.valorCompraProduto, dto.quantidadeProduto, dto.minQuantidadeProduto};
    }

    @Override
    public List<ProdutosDTO> getListaDados() {
        List<Produtos> dados = dao.listar(Produtos.class);
        ProdutosDTO produtosDTO = new ProdutosDTO();
        return produtosDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((ProdutosDTO) dto).builder());
    }
}
