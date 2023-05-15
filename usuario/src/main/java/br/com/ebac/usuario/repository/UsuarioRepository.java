package br.com.ebac.usuario.repository;

import br.com.ebac.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "select u1_0.id,u1_0.data_cadastro,u1_0.email,u1_0.nome from usuario u1_0 where upper(u1_0 .nome)= upper(?1)",
            nativeQuery = true)
    Usuario findPorNome(String nome);
}
