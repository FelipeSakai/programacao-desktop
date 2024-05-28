package br.unigran.dto;

import br.unigran.entidades.Funcionario;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class FuncionarioDTO extends DTO {
    public String nomeFuncionario;
    public Integer numeroID;
    public String numeroCPF;
    public boolean sexoFuncionario;
    public String telefoneFuncionario;
    public String emailFuncionario;
    public Date dataAdmissaoFuncionario;
    public float salarioFuncionario;
    public String cargoFuncionario;
    
    @Override
    public Funcionario builder(){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nomeFuncionario);
        funcionario.setId(id!=null?Integer.valueOf(id):01);
        funcionario.setCPF(numeroCPF);
        funcionario.setSexo(sexoFuncionario);
        funcionario.setTelefone(telefoneFuncionario);
        funcionario.setEmail(emailFuncionario);
        funcionario.setDataAdmissao(dataAdmissaoFuncionario);
        funcionario.setSalario(salarioFuncionario);
        funcionario.setCargo(cargoFuncionario);
        return funcionario;
    }
    public List getListaDados(List<Funcionario> dados) {
        List dadosDTO = new LinkedList();
        for (Funcionario dado : dados) {
            dadosDTO.add(converte(dado));
        }
        return dadosDTO;
    }
     private Object converte(Funcionario f) {
        
        FuncionarioDTO dto= new FuncionarioDTO();
        dto.nomeFuncionario=f.getNome();
        dto.id=f.getId().toString();
        dto.numeroCPF=f.getCPF();
        dto.sexoFuncionario=f.isSexo();
        dto.telefoneFuncionario=f.getTelefone();
        dto.emailFuncionario=f.getEmail();
        dto.dataAdmissaoFuncionario=f.getDataAdmissao();
        dto.salarioFuncionario=f.getSalario();
        dto.cargoFuncionario=f.getCargo();
                
                
        return dto;
    }
}
    
    
