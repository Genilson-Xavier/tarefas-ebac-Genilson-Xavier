package test.java.br.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ClienteDaoTest.class, ClienteServiceTest.class, ProdutoServiceTest.class})
public class AllTests {

}
