package br.edu.uniritter.searchPhone.repository;

import br.edu.uniritter.searchPhone.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

    @Query("SELECT c FROM Cliente c JOIN  c.telefones t WHERE t.ddd = :ddd AND t.numero = :numero")
    Optional<Cliente> findByDddAndNumero(@Param("ddd") String ddd, @Param("numero") String numero);

}
