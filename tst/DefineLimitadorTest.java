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
		parser.defineLimitador(";");
		assertEquals(parser.getDelimitador(), ";"); //falsificação
	}

}
