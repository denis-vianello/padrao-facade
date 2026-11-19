/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segurancafacade;

/**
 *
 * @author PICHAU
 */
public class ControlePermissao {

    public boolean verificarPermissao(int idFuncionario, String area) {

        if (idFuncionario == 101) {
            return area.equals("Laboratorio") || area.equals("Administracao");
        }

        if (idFuncionario == 102) {
            return area.equals("Administracao");
        }

        return false;
    }
}