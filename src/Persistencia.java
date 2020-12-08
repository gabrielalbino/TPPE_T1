import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
	public File file;
	public File outputFile;
	public FileWriter outputFileWriter;
	public int analiseIndex;
	public BufferedReader reader;

	public Persistencia() {
	}

	public void abrirArquivoSaida(Parser parser, String path) throws EscritaNaoPermitidaException {
		try {			
			outputFile = new File(path);
			outputFileWriter = new FileWriter(outputFile, false);
		}
		catch (IOException e) {
			throw new EscritaNaoPermitidaException("Erro ao abrir o arquivo de saída"); //Triangulação
		}
	}

	
	private void alocarObjetosLeitura(Parser parser) {
		parser.analise = new ArrayList<ArrayList<Integer>>(); //duplicação
		this.analiseIndex = -1;
		this.reader = null;
	}
	
	public void lerDadosAnalise(Parser parser) {
		this.alocarObjetosLeitura(parser);
		try {
			reader = new BufferedReader(new FileReader(this.file));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if(reader != null) {
			String line = null;
			do {
				try {
					line = reader.readLine();
					if(line != null) {
						try {						
							int tempo = Integer.parseInt(line);
							parser.analise.get(analiseIndex).add(tempo);
						} catch (NumberFormatException e) {
							analiseIndex++;
							parser.analise.add(new ArrayList<Integer>());
							
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} 
			} while (line != null);
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void saveFileModoLinha(Parser parser) throws IOException {
		String linha;
		for(int i = 0; i < parser.analise.size(); i++) {
			linha = i + 1 + parser.getDelimitador();
			for(int j = 0; j < parser.analise.get(i).size(); j++) {
				linha += parser.analise.get(i).get(j) + (j != parser.analise.get(i).size() - 1 ? parser.getDelimitador() : "\n");
			}
			outputFileWriter.write(linha);
		}
	}

	void saveFileModoColuna(Parser parser) throws IOException {
		String linha = "";
		Boolean foundAny;
		int index = 0;
		for(int i = 0; i < parser.analise.size(); i++) {
			linha += (i+1) + (i != parser.analise.size() - 1 ? parser.getDelimitador() : "");
		}
		linha += "\n";				
		outputFileWriter.write(linha);
		do {
			linha = "";
			foundAny = false;
			for(int i = 0; i < parser.analise.size(); i++) {
				if(index < parser.analise.get(i).size()) {
					linha += parser.analise.get(i).get(index) + (i != parser.analise.size() - 1 ? parser.delimitador : "\n");
					foundAny = true;
				}
				else {
					linha += (i != parser.analise.size() - 1 ? parser.getDelimitador() : "\n");
				}
			}
			if(foundAny)
				outputFileWriter.write(linha);
			index++;
		} while(foundAny);
	}
}