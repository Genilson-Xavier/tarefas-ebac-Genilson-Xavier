
import br.com.ebac;

public class Main {

    private static ConnectionFactory connectionFactory;

    public static void main(String[] args) {
        connectionFactory.getConnection();
        ClienteDao dao = new ClienteDao();
        Cliente cliente= new Cliente();
        cliente.setId(1);
        cliente.setNome("teste");
        cliente.setCodigo("ABCFD"):
        dao.cadastrar(cliente);
    }
}