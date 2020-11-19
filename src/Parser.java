import java.io.File;

public class Parser {

	private File file;

	public void abrirArquivoAnalise(String path) {
		this.file = new File(path); 
	}

	public File getArquivoAnalise(String path2) {
		return new File("res/analysisTime.out"); //Falsificação
	}
	
}
