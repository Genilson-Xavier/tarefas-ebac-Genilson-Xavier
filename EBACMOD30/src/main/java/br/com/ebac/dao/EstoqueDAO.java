package br.com.ebac.dao;

import br.com.ebac.dao.generic.GenericDAO;
import br.com.ebac.domain.Estoque;
import br.com.ebac.domain.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO extends GenericDAO<Estoque, String> implements IEstoqueDAO{
    public EstoqueDAO(){super();}

    @Override
    public Class<Estoque> getTipoClasse(){return Estoque.class;}

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado){
        entityCadastrado.setIdProdutoFK(entity.getIdProdutoFK());
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(ID, ID_PRODUTO_FK, QUANTIDADE)");
        sb.append("VALUES (nextval('sq_estoque'),?,?)");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getIdProdutoFK());
        stmInsert.setLong(2, entity.getQuantidade());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE ID_PRODUTO_FK = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setLong(1,Long.parseLong(valor));
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_ESTOQUE ");
        sb.append("SET ID_PRODUTO_FK = ?,");
        sb.append("QUANTIDADE = ?,");
        sb.append(" WHERE ID_PRODUTO_FK = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setLong(1, entity.getIdProdutoFK());
        stmUpdate.setLong(2, entity.getQuantidade());
        stmUpdate.setLong(3, entity.getIdProdutoFK());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setLong(1, Long.parseLong(valor));
    }
}
