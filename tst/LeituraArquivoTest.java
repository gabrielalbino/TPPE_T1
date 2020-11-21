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
	public void testeAbrirArquivo1() throws ArquivoNaoEncontradoException {
		String path = "res/analysisTime.out";
		parser.abrirArquivoAnalise(path);
		assertEquals(parser.getArquivoAnalise().getPath(), path);
	}

	@Test(expected = ArquivoNaoEncontradoException.class) //Duplicação
	public void testeAbrirArquivo2() throws ArquivoNaoEncontradoException {
		String path = "arquivoInexistente.out";
		parser.abrirArquivoAnalise(path);
	}

	@Test	//Triangulação
	public void testeAbrirArquivo3() throws ArquivoNaoEncontradoException {
		String path = "res/totalTime.out";
		parser.abrirArquivoAnalise(path);
		assertEquals(parser.getArquivoAnalise().getPath(), path);
	}

}
