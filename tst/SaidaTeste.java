import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SaidaTeste {

	private Parser parser;

	@Before
	public void setUp() throws Exception {
		this.parser = new Parser();
	}

	@Test
	public void AnalysisTeste1() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException, IOException { //falsificação
		BufferedReader reader;
		String line="", expectedLine = "", arquivoAnalise = "res/analysisTime.out", delimitador = ";";
		Boolean modoColuna = true;
		
		for(Integer i = 1; i <= 20; i++) {
			expectedLine += i.toString() + (i != 20 ? ";" : "");
		}
		
		parser.abrirArquivoAnalise(arquivoAnalise);
		parser.defineLimitador(delimitador);
		parser.setModoSaida(modoColuna);
		parser.lerDadosAnalise();
		parser.salvarDadosAnalise();
		
		try {
			reader = new BufferedReader(new FileReader(new File("analysisTimeTab.out")));
			line = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		assertEquals(expectedLine, line);
	}

	@Test
	public void AnalysisTeste2() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException, IOException { //falsificação
		BufferedReader reader;
		String line="", expectedLine = "", arquivoAnalise = "res/analysisTime.out", delimitador = ";";
		Boolean modoColuna = false;
		
		expectedLine = "1;439;705;738;729;752;740;658;713;765;710";
		
		parser.abrirArquivoAnalise(arquivoAnalise);
		parser.defineLimitador(delimitador);
		parser.setModoSaida(modoColuna);
		parser.lerDadosAnalise();
		parser.salvarDadosAnalise();
		
		try {
			reader = new BufferedReader(new FileReader(new File("analysisTimeTab.out")));
			line = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		assertEquals(expectedLine, line);
	}

}
