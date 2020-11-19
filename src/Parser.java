
import java.io.File;

public class Parser {

	private File file;

	public void abrirArquivoAnalise(String path) throws ArquivoNaoEncontradoException {
		File temp = new File(path); 
		if(temp.exists()) {
			this.file = temp;
		}
		else {
			throw new ArquivoNaoEncontradoException();// Duplicação
		}
	}

	public File getArquivoAnalise(String path2) {
		return file; //Triangulação
	}
	
}
