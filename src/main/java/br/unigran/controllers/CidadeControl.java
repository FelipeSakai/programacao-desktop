package br.unigran.controllers;

import br.unigran.dto.CidadeDTO;
import br.unigran.dto.DTO;
import br.unigran.dto.FuncionarioDTO;
import br.unigran.entidades.Cidade;
import br.unigran.entidades.Funcionario;
import br.unigran.persistencia.cidade.CidadeDao;
import br.unigran.persistencia.cidade.CidadeImpl;
import java.util.List;


 public class CidadeControl implements Controller {

    CidadeDao dao = new CidadeImpl();

    
    @Override
    public void salvar(DTO dto)  {

        dao.atualiza(dto.builder());

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
        FuncionarioDTO dto = (FuncionarioDTO) o;
        return new Object[]{dto.id, dto.nomeFuncionario};
    }

    @Override
    public List getListaDados() {
        List<Funcionario> dados = dao.listar(Cidade.class);
        CidadeDTO CidadeDTO = new CidadeDTO();
        return CidadeDTO.getListaDados(dados);
    }

    @Override
    public void remover(DTO dto) {
        dao.remove(((CidadeDTO) dto).builder());
    }
}
