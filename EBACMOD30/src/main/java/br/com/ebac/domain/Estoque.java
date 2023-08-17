package br.com.ebac.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import br.com.ebac.dao.Persistente;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente {
    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @TipoChave("getIdProdutoFK")
    @ColunaTabela(dbName = "id_produto_fk", setJavaName = "setIdProdutoFK")
    private Long idProdutoFK;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Long quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProdutoFK() {
        return idProdutoFK;
    }

    public void setIdProdutoFK(Long idProdutoFK) {
        this.idProdutoFK = idProdutoFK;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
