package br.edu.uniritter.searchPhone.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ClienteTest {

    private Cliente cliente;
    private Telefone telefone;

    @Before
    public void setUp() throws Exception {
        cliente = new Cliente("João", "12345678901");
        telefone = new Telefone("12", "123456789");
    }

    @Test
    public void cadastrar_cliente() throws Exception {
        assertEquals("João", cliente.getNome());
        assertEquals("12345678901", cliente.getCpf());
    }

    @Test
    public void cadastrar_cliente_com_telefone() throws Exception {
        cliente.setTelefones(Arrays.asList(telefone));

        assertEquals("12", cliente.getTelefones().get(0).getDdd());
        assertEquals("123456789", cliente.getTelefones().get(0).getNumero());
    }
}
