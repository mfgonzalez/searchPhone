package br.edu.uniritter.searchPhone.controller;

import br.edu.uniritter.searchPhone.service.ClienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClienteService service;

    @InjectMocks
    private ClienteController controller;

    @Test
    public void criar_ok() {
        assertEquals(1, 1);
    }


}
