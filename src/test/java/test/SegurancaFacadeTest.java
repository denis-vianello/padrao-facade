/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import com.mycompany.segurancafacade.SegurancaFacade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SegurancaFacadeTest {

    @Test
    public void testarAcessoAutorizado() {

        SegurancaFacade seguranca = new SegurancaFacade();

        String resultado = seguranca.acessarArea(
                101, "senha123", "Laboratorio");

        assertEquals("Acesso autorizado a area: Laboratorio", resultado);
    }

    @Test
    public void testarFuncionarioSemPermissao() {

        SegurancaFacade seguranca = new SegurancaFacade();

        String resultado = seguranca.acessarArea(
                102, "senha456", "Laboratorio");

        assertEquals("Acesso negado: funcionario sem permissao.", resultado);
    }

    @Test
    public void testarSenhaIncorreta() {

        SegurancaFacade seguranca = new SegurancaFacade();

        String resultado = seguranca.acessarArea(
                101, "senhaerrada", "Laboratorio");

        assertEquals("Acesso negado: falha na autenticacao.", resultado);
    }

    @Test
    public void testarFuncionarioInexistente() {

        SegurancaFacade seguranca = new SegurancaFacade();

        String resultado = seguranca.acessarArea(
                999, "senha999", "Administracao");

        assertEquals("Acesso negado: falha na autenticacao.", resultado);
    }

    @Test
    public void testarRegistroDeAcessos() {

        SegurancaFacade seguranca = new SegurancaFacade();

        seguranca.acessarArea(101, "senha123", "Laboratorio");
        seguranca.acessarArea(102, "senha456", "Laboratorio");
        seguranca.acessarArea(101, "senhaerrada", "Administracao");

        assertEquals(3, seguranca.getRegistroAcesso().getRegistros().size());

        assertTrue(seguranca.getRegistroAcesso().getRegistros()
                .get(0).contains("AUTORIZADO"));

        assertTrue(seguranca.getRegistroAcesso().getRegistros()
                .get(1).contains("NEGADO"));

        assertTrue(seguranca.getRegistroAcesso().getRegistros()
                .get(2).contains("NEGADO"));
    }
}
