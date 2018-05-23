package br.edu.uniritter.searchPhone.service;

import br.edu.uniritter.searchPhone.model.Cliente;
import br.edu.uniritter.searchPhone.model.Telefone;
import br.edu.uniritter.searchPhone.service.exception.ClienteNaoEncontradoException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeCpfException;
import br.edu.uniritter.searchPhone.service.exception.UnicidadeTelefoneException;

public interface ClienteService {

    Cliente salvar(Cliente cliente) throws UnicidadeCpfException, UnicidadeTelefoneException;

    Cliente buscarPorTelefone(Telefone telefone) throws ClienteNaoEncontradoException;


}
