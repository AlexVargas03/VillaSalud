/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laboratorio.pruebas;

import com.example.laboratorio.dao.DaoVideojuego;
import com.example.laboratorio.dao.impl.DaoVideojuegoImpl;

/**
 *
 * @author docentesis103b
 */
public class Pruebas {
    public static void main(String[] args) {
        DaoVideojuego dao = new DaoVideojuegoImpl();
        try {
            System.out.println(dao.selectTodo().size());            
        } catch (Exception e) {
            System.out.println(dao.getMensaje());
        }
    }
}
