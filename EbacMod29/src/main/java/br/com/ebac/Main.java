package br.com.ebac;

import br.com.ebac.Dao.ClienteDao;
import br.com.ebac.Factory.ConnectionFactory;
import br.com.ebac.entitys.Cliente;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private static final ClienteDao clienteDao = new ClienteDao();

    public static void main(String[] args) throws Exception {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        /*System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }*/
        connectionFactory.connect();
        Cliente cliente = new Cliente();

        cliente.setNome("Teste");
        cliente.setCodigo("ASWQERTTR");
        clienteDao.cadastrar(cliente);
    }
}