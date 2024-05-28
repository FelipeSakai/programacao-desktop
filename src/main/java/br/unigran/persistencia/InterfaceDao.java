package br.unigran.persistencia;

import java.util.List;


public interface InterfaceDao {

    public default void salvar(Object entidade) {
        Dao.getInstace().salvar(entidade);
    }

    public default void atualiza(Object entidade) {
        Dao.getInstace().atualiza(entidade);
    }

    public default void remove(Object entidade) {
        Dao.getInstace().remove(entidade);
    }

    public default void remove(Integer id,Class clazz){
        Dao.getInstace ().remove(id,clazz);
    }
    public default List listar(Class clazz,String where){
        return Dao.getInstace ().listar(clazz, where);
    }
    public default List listar(Class clazz){
        return Dao.getInstace ().listar(clazz, "");
    }
}
