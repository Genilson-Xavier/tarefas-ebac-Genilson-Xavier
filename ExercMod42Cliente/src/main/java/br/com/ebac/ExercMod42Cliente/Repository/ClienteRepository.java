package br.com.ebac.ExercMod42Cliente.Repository;

import br.com.ebac.ExercMod42Cliente.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
