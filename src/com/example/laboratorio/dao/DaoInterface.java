package com.example.laboratorio.dao;

import java.util.List;
/**
 * Interfaz con clases genéricas para
 * realizar operaciones CRUD con bases de datos
 * @author Jhon
 * @param <C> Clase (entidad)
 * @param <I> Tipo de clave primaria. 
 *              Por ejemplo: Integer o String
 */
public interface DaoInterface<C,I> {
    List<C> selectTodo();
    C selectUno(I id);
    String insertar(C objeto);
    String actualizar(C objeto);
    String eliminar(I id);
    String getMensaje();            
}
