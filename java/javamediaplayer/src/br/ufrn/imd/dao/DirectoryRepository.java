package br.ufrn.imd.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Diretorio;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DirectoryRepository extends BaseRepository<Diretorio>{

	private static DirectoryRepository instance;
	
	public static DirectoryRepository getInstance() {
		if(instance == null) {
			instance = new DirectoryRepository();
		}
		
		return instance;
	}
	
	public DirectoryRepository() {
		this.entities = new ArrayList<Diretorio>();
	}
	
	@Override
	public void seed() {
		try {
			Path filePath = Paths.get("src/br/ufrn/imd/data/diretorios.txt");
			
			List<String> directories = Files.readAllLines(filePath);
			for(String currentDirectory : directories) {
				Diretorio diretorio = new Diretorio(currentDirectory);
				add(diretorio);
			}
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao ler arquivo de diretórios.");
			alert.showAndWait();
		}
	}

	@Override
	public void write(Diretorio entity) {
		
		try {			
			Path filePath = Paths.get("src/br/ufrn/imd/data/diretorios.txt");
			
			List<String> directories = Files.readAllLines(filePath);
			for(String currentDirectory : directories) {
				if(currentDirectory.equals(entity.getPath())) {
					throw new Exception("Diretorio ja cadastrado");
				}
			}
			
			Files.write(filePath, (entity.getPath() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
			add(entity);
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao adicionar diretório.");
			alert.showAndWait();
		}
		catch(Exception ex) {
			Alert alert = new Alert(AlertType.WARNING, ex.getMessage());
			alert.showAndWait();
		}
	}
}
