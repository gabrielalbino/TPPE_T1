import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ModoArquivoTeste {

	private Parser parser;

	@Before
	public void setUp() throws Exception {
		parser = new Parser();
	}

	@Test
	public void testeModoArquivo1()  { //falsificação
		Boolean modoColuna = true;
		parser.setModoSaida(modoColuna);
		assertEquals(parser.getModoSaida(), modoColuna);
	}

}
