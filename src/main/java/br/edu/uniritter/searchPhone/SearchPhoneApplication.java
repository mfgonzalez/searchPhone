package br.edu.uniritter.searchPhone;

import br.edu.uniritter.searchPhone.model.Cliente;
import br.edu.uniritter.searchPhone.model.Telefone;
import br.edu.uniritter.searchPhone.repository.ClienteRepository;
import br.edu.uniritter.searchPhone.service.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootApplication
public class SearchPhoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchPhoneApplication.class, args);
	}
}
