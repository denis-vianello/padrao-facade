/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segurancafacade;

/**
 *
 * @author PICHAU
 */
public class Autenticacao {

    public boolean autenticar(int idFuncionario, String senha) {

        if (idFuncionario == 101 && senha.equals("senha123")) {
            return true;
        }

        if (idFuncionario == 102 && senha.equals("senha456")) {
            return true;
        }

        return false;
    }
}
