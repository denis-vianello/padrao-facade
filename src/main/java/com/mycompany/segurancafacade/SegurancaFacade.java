/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segurancafacade;

/**
 *
 * @author PICHAU
 */
public class SegurancaFacade {

    private Autenticacao autenticacao;
    private ControlePermissao controlePermissao;
    private RegistroAcesso registroAcesso;

    public SegurancaFacade() {
        this.autenticacao = new Autenticacao();
        this.controlePermissao = new ControlePermissao();
        this.registroAcesso = new RegistroAcesso();
    }

    public String acessarArea(int idFuncionario, String senha, String area) {

        boolean autenticado = autenticacao.autenticar(idFuncionario, senha);

        if (!autenticado) {
            registroAcesso.registrarAcesso(idFuncionario, area, false);
            return "Acesso negado: falha na autenticacao.";
        }

        boolean autorizado = controlePermissao.verificarPermissao(idFuncionario, area);

        registroAcesso.registrarAcesso(idFuncionario, area, autorizado);

        if (autorizado) {
            return "Acesso autorizado a area: " + area;
        }

        return "Acesso negado: funcionario sem permissao.";
    }

    public RegistroAcesso getRegistroAcesso() {
        return registroAcesso;
    }
}