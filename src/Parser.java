
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	String delimitador;
	private Boolean modoColuna;
	ArrayList<ArrayList<Integer>> analise;
	Persistencia persistencia = new Persistencia();

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
		persistencia.abrirArquivoSaida(this, path);
	}
	
	public File getArquivoSaida() {
		return persistencia.outputFile; //Triangulação
	}
	
	public void setModoSaida(Boolean modoColuna) {
		this.modoColuna = modoColuna; //duplicação
	}
	
	public Boolean getModoSaida() {
		return modoColuna; //duplicação
	}

	public void abrirArquivoAnalise(String path) throws ArquivoNaoEncontradoException {
		File temp = new File(path); 
		if(temp.exists()) {
			this.persistencia.file = temp;
		}
		else {
			throw new ArquivoNaoEncontradoException(path);// Duplicação
		}
	}

	public File getArquivoAnalise() {
		return persistencia.file; //Triangulação
	}

	
	public void lerDadosAnalise() {
		persistencia.lerDadosAnalise(this);
	}

	public ArrayList<ArrayList<Integer>> getDadosAnalise() {
		return analise; // duplicação
	}

	public void salvarDadosAnalise() throws EscritaNaoPermitidaException, IOException {// falsificação
		String arquivoSaida = "totalTimeTab.out";
		if(persistencia.file.getPath().contains("analysis")) {
			arquivoSaida = "analysisTimeTab.out";
		}
		abrirArquivoSaida(arquivoSaida);
		if(getModoSaida()) {
			persistencia.saveFileModoColuna(this);
		}
		if(!getModoSaida()) {
			persistencia.saveFileModoLinha(this);
		}
		persistencia.outputFileWriter.close();
	}

}
