package br.unigran.controllers;

import br.unigran.dto.CidadeDTO;
import br.unigran.dto.DTO;
import br.unigran.entidades.Cidade;
import br.unigran.persistencia.cidade.CidadeDao;
import br.unigran.persistencia.cidade.CidadeImpl;
import java.util.List;

public class CidadeControl implements Controller {

    CidadeDao dao = new CidadeImpl();

    @Override
    public void salvar(DTO dto) {
        dao.atualiza(((CidadeDTO) dto).builder());
    }

    public void salvar(String[] func) throws Exception {
        dao.salvar(builder(func));
    }

    private Cidade builder(String[] valores) throws Exception {
        Cidade cidade = new Cidade();
        cidade.setNome(valores[0]);

        if (cidade.getNome() == null) {
            throw new Exception("Nome invalido");
        }
        return cidade;
    }

    @Override
    public String[] getTitulosColunas() {
        return new String[]{"id", "Nome"};
    }

    @Override
    public Object[] getDados(DTO o) {
        CidadeDTO dto = (CidadeDTO) o;
        return new Object[]{dto.idCidade, dto.nomeCidade};
    }

    @Override
    public List<CidadeDTO> getListaDados() {
        List<Cidade> dados = dao.listar(Cidade.class);
        CidadeDTO cidadeDTO = new CidadeDTO();
        return cidadeDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((CidadeDTO) dto).builder());
    }
}
