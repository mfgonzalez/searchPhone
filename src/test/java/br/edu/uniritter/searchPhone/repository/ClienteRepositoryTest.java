package br.edu.uniritter.searchPhone.repository;

import br.edu.uniritter.searchPhone.model.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
@Sql(value = "/load-db.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clear-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repository;

    @Test
    public void deve_procurar_Cliente_pelo_cpf() throws Exception {
        Optional<Cliente> optional = repository.findByCpf("38767897100");

        assertTrue(optional.isPresent());

        Cliente Cliente = optional.get();

        assertEquals(Long.valueOf(3), Cliente.getId());
        assertEquals("Cauê", Cliente.getNome());
        assertEquals("38767897100", Cliente.getCpf());
    }

    @Test
    public void nao_deve_encontrar_Cliente_com_cpf_invalido() throws Exception {
        Optional<Cliente> optional = repository.findByCpf("38767891232");

        assertFalse(optional.isPresent());
    }

    @Test
    public void deve_encontrar_Cliente_pelo_ddd_e_numero() throws Exception {
        Optional<Cliente> optional = repository.findByDddAndNumero("86", "35006330");

        assertTrue(optional.isPresent());

        Cliente Cliente = optional.get();

        assertEquals(Long.valueOf(3), Cliente.getId());
        assertEquals("Cauê", Cliente.getNome());
        assertEquals("38767897100", Cliente.getCpf());
    }

    @Test
    public void nao_deve_encontrar_Cliente_com_ddd_e_numero_nao_cadastrado() throws Exception {
        Optional<Cliente> optional = repository.findByDddAndNumero("00", "35000000");

        assertFalse(optional.isPresent());
    }
}
