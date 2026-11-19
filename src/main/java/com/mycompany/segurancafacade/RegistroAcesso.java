/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segurancafacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PICHAU
 */


public class RegistroAcesso {

    private List<String> registros = new ArrayList<>();

    public void registrarAcesso(int idFuncionario, String area, boolean autorizado) {

        String resultado = autorizado ? "AUTORIZADO" : "NEGADO";

        registros.add("Funcionário: " + idFuncionario
                + " | Área: " + area
                + " | Resultado: " + resultado);
    }

    public List<String> getRegistros() {
        return registros;
    }
}