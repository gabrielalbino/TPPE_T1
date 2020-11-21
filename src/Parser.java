
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Parser {

	private File file, outputFile;
	private FileWriter outputFileWriter;
	private String delimitador;

	public void abrirArquivoAnalise(String path) throws ArquivoNaoEncontradoException {
		File temp = new File(path); 
		if(temp.exists()) {
			this.file = temp;
		}
		else {
			throw new ArquivoNaoEncontradoException(path);// Duplicação
		}
	}

	public File getArquivoAnalise() {
		return file; //Triangulação
	}

	public void defineLimitador(String delimitador) throws DelimitadorInvalidoException {
		if(delimitador.length() != 1) {
			throw new DelimitadorInvalidoException("O delimitador deve ser um único caractere.");
		}
		else {
			this.delimitador = delimitador;
		}
	}
	
	public String getDelimitador() {
		return this.delimitador; //triangulação
	}
	
	public void abrirArquivoSaida(String path) throws EscritaNaoPermitidaException {
		try {			
			this.outputFile = new File(path);
			this.outputFileWriter = new FileWriter(this.outputFile);
		}
		catch (IOException e) {
			throw new EscritaNaoPermitidaException("Erro ao abrir o arquivo de saída"); //Triangulação
		}
	}
	
	public File getArquivoSaida() {
		return outputFile; //Triangulação
	}
	
}
