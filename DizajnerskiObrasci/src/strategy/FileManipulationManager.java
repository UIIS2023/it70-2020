package strategy;

public class FileManipulationManager implements FileManipulation {

	FileManipulation file;
	
	
	public FileManipulationManager(FileManipulation file) {
		this.file = file;
	}

	@Override
	public void saveFile(String fileName) {
		file.saveFile(fileName);

	}

	@Override
	public void loadFile(String fileName) {
		file.loadFile(fileName);

	}

}
