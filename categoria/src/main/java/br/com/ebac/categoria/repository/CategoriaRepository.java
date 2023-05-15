package br.com.ebac.categoria.repository;

import br.com.ebac.categoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "select u1_0.id,u1_0.data_cadastro,u1_0.descricao,u1_0.nome,u1_0.id_usuario from categoria u1_0 where upper(u1_0 .nome)= upper(?1)",
            nativeQuery = true)
    Categoria findPorNome(String nome);
}
