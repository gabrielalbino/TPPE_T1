import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LeituraArquivoTest {

	private Parser parser;

	@Before
	public void setUp() throws Exception {
		parser = new Parser();
	}

	@Test
	public void testeAbrirArquivo1() {
		String path = "res/analysisTime.out";
		parser.abrirArquivoAnalise(path);
		assertEquals(parser.getArquivoAnalise(path).getPath(), path);
	}

}
