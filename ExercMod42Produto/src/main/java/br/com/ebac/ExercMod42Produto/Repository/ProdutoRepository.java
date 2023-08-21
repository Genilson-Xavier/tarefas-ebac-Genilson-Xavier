package br.com.ebac.ExercMod42Produto.Repository;

import br.com.ebac.ExercMod42Produto.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
