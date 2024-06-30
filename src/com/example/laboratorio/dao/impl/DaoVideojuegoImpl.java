package com.example.laboratorio.dao.impl;

import com.example.laboratorio.dao.DaoVideojuego;
import com.example.laboratorio.entidades.Videojuego;
import com.example.laboratorio.util.ConectaBD;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class DaoVideojuegoImpl implements DaoVideojuego {

    private ConectaBD conexion;
    private String mensaje;

    public DaoVideojuegoImpl() {
        conexion = new ConectaBD();
    }

    @Override
    public List<Videojuego> selectTodo() {
        List<Videojuego> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("consola,")
                .append("nombre,")
                .append("genero,")
                .append("clasificacion,")
                .append("descripcion,")
                .append("id_desarrollador,")
                .append("id_distribuidor")
                .append(" FROM videojuego");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Videojuego videojuego = new Videojuego();
                videojuego.setId(rs.getInt(1));
                videojuego.setConsola(rs.getString(2));
                videojuego.setNombre(rs.getString(3));
                videojuego.setGenero(rs.getString(4));
                videojuego.setClasificacion(rs.getString(5));
                videojuego.setDescripcion(rs.getString(6));
                videojuego.setId_desarrollador(rs.getInt(7));
                videojuego.setId_distribuidor(rs.getInt(8));
                lista.add(videojuego);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Videojuego selectUno(Integer id) {
        Videojuego videojuego = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("consola,")
                .append("nombre,")
                .append("genero,")
                .append("clasificacion,")
                .append("descripcion,")
                .append("id_desarrollador,")
                .append("id_distribuidor")
                .append(" FROM videojuego")
                .append(" WHERE id = ?");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                videojuego = new Videojuego();
                videojuego.setId(rs.getInt(1));
                videojuego.setConsola(rs.getString(2));
                videojuego.setNombre(rs.getString(3));
                videojuego.setGenero(rs.getString(4));
                videojuego.setClasificacion(rs.getString(5));
                videojuego.setDescripcion(rs.getString(6));
                videojuego.setId_desarrollador(rs.getInt(7));
                videojuego.setId_distribuidor(rs.getInt(8));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return videojuego;
    }

    @Override
    public String insertar(Videojuego objeto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO videojuego(")                
                .append("consola,")
                .append("nombre,")
                .append("genero,")
                .append("clasificacion,")
                .append("descripcion,")
                .append("id_desarrollador,")
                .append("id_distribuidor")
                .append(") VALUES (?,?,?,?,?,?,?)");

        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, objeto.getConsola());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getGenero());
            ps.setString(4, objeto.getClasificacion());
            ps.setString(5, objeto.getDescripcion());
            ps.setInt(6, objeto.getId_desarrollador());
            ps.setInt(7, objeto.getId_distribuidor());
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
    public String actualizar(Videojuego objeto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE videojuego SET ")
                .append("consola = ?,")
                .append("nombre = ?,")
                .append("genero = ?,")
                .append("clasificacion = ?,")
                .append("descripcion = ?,")
                .append("id_desarrollador = ?,")
                .append("id_distribuidor = ?")
                .append(" WHERE id = ?");

        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, objeto.getConsola());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getGenero());
            ps.setString(4, objeto.getClasificacion());
            ps.setString(5, objeto.getDescripcion());
            ps.setInt(6, objeto.getId_desarrollador());
            ps.setInt(7, objeto.getId_distribuidor());
            ps.setInt(8, objeto.getId());
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
        sql.append("DELETE FROM videojuego ")
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
