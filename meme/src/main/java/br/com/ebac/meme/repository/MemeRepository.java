package br.com.ebac.meme.repository;

import br.com.ebac.meme.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemeRepository extends JpaRepository<Meme, Integer> {
    @Query(value = "select * from meme where data_cadastro = current_date limit 1",
            nativeQuery = true)
    Meme findDia();
}
