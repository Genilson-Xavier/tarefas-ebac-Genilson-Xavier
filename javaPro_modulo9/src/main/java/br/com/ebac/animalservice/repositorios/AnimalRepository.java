package br.com.ebac.animalservice.repositorios;

import br.com.ebac.animalservice.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query(value = "SELECT a.* FROM animal a WHERE a.data_Adocao IS NULL ORDER BY a.data_Entrada", nativeQuery = true)
    List<Animal> findNotAdoted();

    @Query(value = "SELECT a.* FROM animal a WHERE a.data_Adocao IS NOT NULL", nativeQuery = true)
    List<Animal> findAdoted();

    @Query(nativeQuery = true)
    List<FuncionariosDto> findRecebidosPorFuncionarios();
}
