package br.edu.uniritter.searchPhone.service;

import br.edu.uniritter.searchPhone.model.Cliente;
import br.edu.uniritter.searchPhone.model.Telefone;
import br.edu.uniritter.searchPhone.repository.ClienteRepository;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeCpfException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeTelefoneException;
import br.edu.uniritter.searchPhone.service.impl.ClienteServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ClienteServiceTest {

    private static final String NOME = "João";
    private static final String CPF = "01234567890";
    private static final String DDD = "51";
    private static final String NUMERO = "999999744";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @MockBean
    private ClienteRepository repository;

    private ClienteService service;
    private Cliente cliente;

    @Before
    public void setUp() throws Exception {
        service = new ClienteServiceImpl(repository);

        cliente =  new Cliente(NOME, CPF);

        cliente.setTelefones(Collections.singletonList(new Telefone(DDD, NUMERO)));
    }

    @Test
    public void salvar_cliente_no_repositorio() throws Exception {
        service.salvar(cliente);

        verify(repository).save(cliente);
    }

    @Test
    public void nao_deve_salvar_cliente_com_telefone_ja_cadastrado() throws Exception {
        when(repository.findByDddAndNumero(DDD, NUMERO)).thenReturn(Optional.of(cliente));

        expectedException.expect(UnicidadeTelefoneException.class);
        expectedException.expectMessage("Já existe cliente cadastrado com o telefone (" + DDD + ") " + NUMERO);

        service.salvar(cliente);
    }

    @Test
    public void nao_deve_salvar_cliente_com_cpf_ja_cadastrado() throws Exception {
        when(repository.findByCpf(CPF)).thenReturn(Optional.of(cliente));

        expectedException.expect(UnicidadeCpfException.class);
        expectedException.expectMessage("Já existe cliente cadastrado com o CPF '" + CPF + "'");

        service.salvar(cliente);
    }
}
