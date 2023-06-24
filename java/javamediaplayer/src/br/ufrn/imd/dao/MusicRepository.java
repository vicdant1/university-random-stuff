package br.ufrn.imd.dao;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


import br.ufrn.imd.model.Musica;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MusicRepository extends BaseRepository<Musica> {
	private static MusicRepository instance;
	public static MusicRepository getInstance() {
		if(instance == null) {
			instance = new MusicRepository();
		}
		
		return instance;
	}
	
	public MusicRepository() {
		this.entities = new ArrayList<Musica>();
	}

	@Override
	public void seed() {
		try {			
			Path filePath = Paths.get("src/br/ufrn/imd/data/musicas.txt");
			
			List<String> musics = Files.readAllLines(filePath);
			for(String music : musics) {
				String[] songData = music.split(",");
				String name = songData[0];
				String path = songData[1];
				
				Musica currentMusic = new Musica(name, path);
				add(currentMusic);
			}
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao ler arquivo de músicas.");
			alert.showAndWait();
		}
	}

	@Override
	public void write(Musica entity) {
		try {			
			Path filePath = Paths.get("src/br/ufrn/imd/data/musicas.txt");
			
			List<String> songs = Files.readAllLines(filePath);
			for(String currentSong : songs) {
				String[] songData = currentSong.split(",");
				String name = songData[0];
				String path = songData[1].replace("\\","/");
				
				if(name.equals(entity.getNome()) && path.equals(entity.getCaminho().replace("\\","/"))) {
					return;
				}
			}
			
			Files.write(filePath, (entity.getNome() + "," + entity.getCaminho().replace("\\","/") + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
			add(entity);
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao ler arquivo de músicas.");
			alert.showAndWait();
		}
	}
	
	@Override
	public ArrayList<Musica> getEntities() {
		return new ArrayList<Musica>(this.entities);
	}
}
