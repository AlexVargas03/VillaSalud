package com.example.laboratorio.dao.impl;

import com.example.laboratorio.dao.DaoDistribuidor;
import com.example.laboratorio.entidades.Distribuidor;
import com.example.laboratorio.util.ConectaBD;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class DaoDistribuidorImpl implements DaoDistribuidor {

    private ConectaBD conexion;
    private String mensaje;

    public DaoDistribuidorImpl() {
        conexion = new ConectaBD();
    }

    @Override
    public List<Distribuidor> selectTodo() {
        List<Distribuidor> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre")
                .append(" FROM distribuidor");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Distribuidor distribuidor = new Distribuidor();
                distribuidor.setId(rs.getInt(1));
                distribuidor.setNombre(rs.getString(2));
                lista.add(distribuidor);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Distribuidor selectUno(Integer id) {
        Distribuidor distribuidor = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre")
                .append(" FROM distribuidor")
                .append(" WHERE id = ?");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                distribuidor = new Distribuidor();
                distribuidor.setId(rs.getInt(1));
                distribuidor.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return distribuidor;
    }

    @Override
    public String insertar(Distribuidor objeto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO distribuidor(")
                .append("nombre")
                .append(") VALUES (?)");

        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, objeto.getNombre());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0)
                    ? "No se insertó"
                    : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String actualizar(Distribuidor objeto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE distribuidor SET ")
                .append("nombre = ?")
                .append(" WHERE id = ?");

        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getId());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0)
                    ? "No se actualizó"
                    : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String eliminar(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM distribuidor ")
                .append("WHERE id = ?");

        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            int cont = ps.executeUpdate();
            mensaje = (cont == 0)
                    ? "No se eliminó"
                    : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

}
