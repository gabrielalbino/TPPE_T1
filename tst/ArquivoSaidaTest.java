import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ArquivoSaidaTest {

	private Parser parser;

	@Before
	public void setUp() throws Exception {
		this.parser = new Parser();
	}

	@Test
	public void testeArquivoOutput1() throws EscritaNaoPermitidaException {
		String path = "output.out";
		parser.persistencia.abrirArquivoSaida(parser, path);
		assertEquals(parser.getArquivoSaida().getPath(), path);
	}


	@Test
	public void testeArquivoOutput2() throws EscritaNaoPermitidaException { //Duplicação
		String path = "output2.out";
		parser.persistencia.abrirArquivoSaida(parser, path);
		assertEquals(parser.getArquivoSaida().getPath(), path);
	}

	@Test(expected = EscritaNaoPermitidaException.class)
	public void testeArquivoOutput3() throws EscritaNaoPermitidaException { //Triangulação
		String path = "/saidadInvalida.out";
		parser.persistencia.abrirArquivoSaida(parser, path);
	}

}
