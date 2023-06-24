package br.ufrn.imd.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Musica;
import br.ufrn.imd.model.Playlist;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PlaylistRepository extends BaseRepository<Playlist> {
	private static PlaylistRepository instance;
	
	public PlaylistRepository() {
		this.entities = new ArrayList<Playlist>();
	}
	
	public static PlaylistRepository getInstance() {
		if(instance == null) {
			instance = new PlaylistRepository();
		}
		
		return instance;
	}
	
	@Override
	public void seed() {
		try {
			File dataDirectory = new File("src/br/ufrn/imd/data/");
			File[] files = dataDirectory.listFiles();
			for (File file : files) {
				if (!file.getName().contains("playlist"))
					continue;
				
				String[] playlistData = file.getName().split("_");
				String userId = playlistData[1];
				String playlistName = playlistData[2].replace(".txt", "");

				Path filepath = Paths.get(file.getPath());
				List<String> playlistSongs = Files.readAllLines(filepath);
				
				Playlist playlist = new Playlist(userId, playlistName, new ArrayList<String>(playlistSongs));
				
				add(playlist);
			}
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao ler arquivos de playlists.");
			alert.showAndWait();
		}
	}
	
	@Override
	public void write(Playlist entity) {
		add(entity);
	}
	
	public boolean createPlaylist(Playlist entity) {
		try {
			String playlistFileName = "playlist_" + entity.getUserId() + "_" + entity.getNome() + ".txt";
			
			File dataDirectory = new File("src/br/ufrn/imd/data/");
			File[] files = dataDirectory.listFiles();
			for (File file : files) {
				if(file.getName().contains(playlistFileName))
					throw new Exception("Playlist já cadastrada.");
			}
			
			Path filePath = Paths.get("src/br/ufrn/imd/data/" + playlistFileName);
			Files.createFile(filePath);
			
			for(String song : entity.getMusicas()) {
				Files.write(filePath, (song + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);			
			}
			
			write(entity);
			
			return true;
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao criar playlist, tente novamente.");
			alert.showAndWait();
		}
		catch(Exception ex) {
			Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
			alert.showAndWait();
		}
		
		return false;
	}
	
	public Playlist getPlaylistByName(String userId, String playlistName) {
		Playlist playlist = this.entities.get(0);
		
		for(Playlist localPlaylist : this.entities) {
			if(localPlaylist.getUserId().equals(userId) && localPlaylist.getNome().equals(playlistName)) {
				playlist = localPlaylist;
			}
		}
		
		return playlist;
	}
	
	public ArrayList<Playlist> getPlaylistsByUser(String userId){
		ArrayList<Playlist> userPlaylists = new ArrayList<Playlist>();
		
		for(Playlist playlist : this.entities) {
			if(playlist.getUserId().equals(userId)) {
				userPlaylists.add(playlist);
			}
		}
		
		return userPlaylists;
	}
}
