package br.ufrn.imd.controle;

import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.dao.MusicRepository;
import br.ufrn.imd.dao.PlaylistRepository;
import br.ufrn.imd.dao.UserRepository;
import br.ufrn.imd.model.Musica;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class NovaPlaylistController {

    @FXML
    private Button btnCriarPlaylist;

    @FXML
    private TextField inputNamePlaylist;

    @FXML
    private Label lblRegMessage;

    @FXML
    private ScrollPane scrollPaneListMusics;
    
    private MusicRepository musicRepository;
    private UserRepository userRepository;
    private PlaylistRepository playlistRepository;
    
    private VBox musicContainer;
    
    public NovaPlaylistController() {
		this.musicRepository = MusicRepository.getInstance();
		this.userRepository = UserRepository.getInstance();
		this.playlistRepository = PlaylistRepository.getInstance();
		this.musicContainer = new VBox();
	}

	@FXML
	private void initialize() {
		seedMusicPane();
    }

	private void seedMusicPane() {
		musicContainer = new VBox();
		ArrayList<Musica> songs = musicRepository.getEntities();
		for (Musica song : songs) {
			CheckBox checkbox = new CheckBox(song.getNome());
			checkbox.setTextFill(Color.web("#6C63FF"));
			checkbox.setBorder(null);

			musicContainer.getChildren().add(checkbox);
		}
		
		scrollPaneListMusics.setContent(musicContainer);
	}
    
    @FXML
    void click_btnCriarPlaylist(ActionEvent event) {
		String playlistName = inputNamePlaylist.getText();
    	if(playlistName.isEmpty() || playlistName.isBlank()){
    		lblRegMessage.setTextFill(Color.RED);
    		lblRegMessage.setText("Informe o nome da playlist.");
    		return;
    	}
    	
    	// validar se esse usuario ja tem uma playlist com esse mesmo nome
    	
    	int selectedSongsCounter = 0;
    	ArrayList<String> playlistSongs = new ArrayList<String>();
    	for(Node element : musicContainer.getChildren()) {
    		CheckBox currentSong = ((CheckBox)element);
    		if(!currentSong.isSelected()) continue;
    		
    		selectedSongsCounter++;
    		for(Musica song : this.musicRepository.getEntities()) {
    			if(song.getNome() == currentSong.getText())
    				playlistSongs.add(song.getNome() + "," + song.getCaminho());
    		}
    	}
    	
    	if(selectedSongsCounter == 0) {
    		lblRegMessage.setTextFill(Color.RED);
    		lblRegMessage.setText("Selecione alguma música.");
    		return;
    	}
    	
    	Usuario creatorUser = this.userRepository.getAuthenticatedUser();
    	Playlist playlist = new Playlist(creatorUser.getId(), playlistName, playlistSongs); 
    	
    	if(this.playlistRepository.createPlaylist(playlist)) {
    		
    		lblRegMessage.setTextFill(Color.GREEN);
    		lblRegMessage.setText("Playlist criada com sucesso.");
    		
    		// Limpar painel de seleção
    		seedMusicPane();
    		inputNamePlaylist.setText("");
    	}
    	
    	
    	MainApp.changeScene("principal");
    }
}
