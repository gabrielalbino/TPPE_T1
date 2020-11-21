import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParserValoresArquivoTeste {

	private Parser parser;

	@Before
	public void setUp() throws Exception {
		this.parser = new Parser();
	}

	@Test
	public void testeParser1() throws ArquivoNaoEncontradoException {
		ArrayList<ArrayList<Integer>> analises;
		parser.abrirArquivoAnalise("res/analysisTime.out");
		parser.lerDadosAnalise();
		analises = parser.getDadosAnalise();
		assertEquals(20, analises.size());
	}

}
