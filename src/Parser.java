
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	private File file, outputFile;
	private FileWriter outputFileWriter;
	private String delimitador;
	private Boolean modoColuna;
	ArrayList<ArrayList<Integer>> analise;
	
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
	
	public void setModoSaida(Boolean modoColuna) {
		this.modoColuna = modoColuna; //duplicação
	}
	
	public Boolean getModoSaida() {
		return modoColuna; //duplicação
	}

	public void lerDadosAnalise() {
		analise = new ArrayList<ArrayList<Integer>>(); //duplicação
		int analiseIndex = -1;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			do {
				line = reader.readLine();
				if(line != null) {
					try {						
						int tempo = Integer.parseInt(line);
						analise.get(analiseIndex).add(tempo);
					} catch (NumberFormatException e) {
						analiseIndex++;
						analise.add(new ArrayList<Integer>());
						
					}
				}
			} while (line != null);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public ArrayList<ArrayList<Integer>> getDadosAnalise() {
		return analise; // duplicação
	}

	public void salvarDadosAnalise() throws EscritaNaoPermitidaException, IOException {// falsificação
		String arquivoSaida = "totalTimeTab.out";
		if(file.getPath().contains("analysis")) {
			arquivoSaida = "analysisTimeTab.out";
		}
		abrirArquivoSaida(arquivoSaida);
		String linha = "";
		for(int i = 0; i < analise.size(); i++) {
			linha += (i+1) + (i != analise.size() - 1 ? ";" : "");
		}
		linha += "\n";
		outputFileWriter.write(linha);
		outputFileWriter.close();
	}
}
