import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DefineLimitadorTest {

	private Parser parser;

	@Before
	public void setUp() throws Exception {
		this.parser = new Parser();
	}

	@Test
	public void testeLimitador1() throws DelimitadorInvalidoException {
		String delimitador = ";";
		parser.defineLimitador(delimitador);
		assertEquals(parser.getDelimitador(), delimitador); //falsificação
	}

	@Test(expected = DelimitadorInvalidoException.class)
	public void testeLimitador2() throws DelimitadorInvalidoException {
		String delimitador = "Teste";
		parser.defineLimitador(delimitador); // Duplicação
	}

	@Test
	public void testeLimitador3() throws DelimitadorInvalidoException {
		String delimitador = ",";
		parser.defineLimitador(delimitador);
		assertEquals(parser.getDelimitador(), delimitador); //triangulação
	}
}
