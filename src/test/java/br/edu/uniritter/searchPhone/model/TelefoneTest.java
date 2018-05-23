package br.edu.uniritter.searchPhone.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TelefoneTest {

    private Telefone telefone;

    @Before
    public void setUp() throws Exception {
        telefone = new Telefone("12", "123456789");
    }

    @Test
    public void cadastrar_telefone() throws Exception {
        assertEquals("12", telefone.getDdd());
        assertEquals("123456789", telefone.getNumero());
    }

    @Test
    public void formato_toString() throws Exception {
        assertEquals("(12) 123456789", telefone.toString());
    }
}
