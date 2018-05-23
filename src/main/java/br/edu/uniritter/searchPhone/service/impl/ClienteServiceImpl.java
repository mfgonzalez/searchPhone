package br.edu.uniritter.searchPhone.service.impl;

import br.edu.uniritter.searchPhone.model.Cliente;
import br.edu.uniritter.searchPhone.model.Telefone;
import br.edu.uniritter.searchPhone.repository.ClienteRepository;
import br.edu.uniritter.searchPhone.service.ClienteService;
import br.edu.uniritter.searchPhone.service.exception.ClienteNaoEncontradoException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeCpfException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeTelefoneException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(Cliente cliente) throws UnicidadeCpfException, UnicidadeTelefoneException {
        Optional<Cliente> optional = repository.findByCpf(cliente.getCpf());

        if(optional.isPresent()) {
            throw new UnicidadeCpfException("Já existe pessoa cadastrada com o CPF '" + cliente.getCpf() + "'");
        }

        optional = repository.findByDddAndNumero(cliente.getTelefones().get(0).getDdd(), cliente.getTelefones().get(0).getNumero());

        if(optional.isPresent()) {
            throw new UnicidadeTelefoneException("Já existe pessoa cadastrada com o telefone " + cliente.getTelefones().get(0).toString());
        }

        return repository.save(cliente);
    }

    @Override
    public Cliente buscarPorTelefone(Telefone telefone) throws ClienteNaoEncontradoException {
        Optional<Cliente> optional = repository.findByDddAndNumero(telefone.getDdd(), telefone.getNumero());

        return optional.orElseThrow(() -> new ClienteNaoEncontradoException("Não existe pessoa com o telefone " + telefone.toString()));
    }
}
