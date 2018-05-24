package br.edu.uniritter.searchPhone.resource;

import br.edu.uniritter.searchPhone.model.ErroWrapper;
import br.edu.uniritter.searchPhone.model.Cliente;
import br.edu.uniritter.searchPhone.model.Telefone;
import br.edu.uniritter.searchPhone.repository.ClienteRepository;
import br.edu.uniritter.searchPhone.service.ClienteService;
import br.edu.uniritter.searchPhone.service.exception.ClienteNaoEncontradoException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeCpfException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeTelefoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    private ClienteService clienteService;
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteResource(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente, HttpServletResponse response) throws UnicidadeCpfException, UnicidadeTelefoneException {
        for(Telefone t : cliente.getTelefones()) {
            t.setCliente(cliente);
        }

        final Cliente clienteSalvo = clienteService.salvar(cliente);

        /* endereco para recuperar o recurso criado */
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{ddd}/{numero}")
                .buildAndExpand(cliente.getTelefones().get(0).getDdd(), cliente.getTelefones().get(0).getNumero())
                .toUri();

        response.setHeader("Location", uri.toASCIIString());

        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{ddd}/{numero}")
    public ResponseEntity<Cliente> buscarPorDddENumero(@PathVariable("ddd") String ddd, @PathVariable("numero") String numero) throws ClienteNaoEncontradoException {
        final Telefone telefone = new Telefone(ddd, numero);

        final Cliente cliente = clienteService.buscarPorTelefone(telefone);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodosClientes() {

        final List<Cliente> clientes = clienteRepository.findAll();

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ErroWrapper> handleClienteNaoEncontradoException(ClienteNaoEncontradoException e) {
        return new ResponseEntity<>(new ErroWrapper(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnicidadeCpfException.class)
    public ResponseEntity<ErroWrapper> handleUnicidadeCpfException(UnicidadeCpfException e) {
        return new ResponseEntity<>(new ErroWrapper(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnicidadeTelefoneException.class)
    public ResponseEntity<ErroWrapper> handleUnicidadeTelefone(UnicidadeTelefoneException e) {
        return new ResponseEntity<>(new ErroWrapper(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
