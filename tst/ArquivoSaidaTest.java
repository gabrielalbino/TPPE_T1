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
	public void testeArquivoOutput1() throws IOException {
		String path = "output.out";
		parser.abrirArquivoSaida(path);
		assertEquals(parser.getArquivoSaida().getPath(), path);
	}

}
