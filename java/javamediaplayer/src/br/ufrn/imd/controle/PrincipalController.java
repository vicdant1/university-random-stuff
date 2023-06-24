package br.ufrn.imd.controle;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.dao.DirectoryRepository;
import br.ufrn.imd.dao.MusicRepository;
import br.ufrn.imd.dao.PlaylistRepository;
import br.ufrn.imd.dao.UserRepository;
import br.ufrn.imd.model.Diretorio;
import br.ufrn.imd.model.Musica;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.Usuario;
import javafx.event.ActionEvent;

public class PrincipalController {
	@FXML
	private Button buttonCriarUser;

	@FXML
	private Button playButton;
	@FXML
	private Button nextButton;

	@FXML
	private Button resetButton;

	@FXML
	private Button previousButton;

	@FXML
	private ProgressBar progressBar;

	@FXML
	private Button addDirectoryButton;

	@FXML
	private Label labelNameUser;

	@FXML
	private Label labelNameMusic;

	@FXML
	private Label labelNamePlaylist;

	@FXML
	private Label labelPlaylist;

	@FXML
	private ScrollPane scrollPaneDirectorys;

	@FXML
	private ScrollPane scrollPaneMusics;

	@FXML
	private ScrollPane scrollPanePlaylists;

	@FXML
	private Button newPlaylistButton;

	@FXML
	private Button addFileButton;

	@FXML
	private Label wrongPlay;

	private MediaPlayer mediaPlayer;
	private boolean isPlaying;
	private Musica currentSong;

	private UserRepository userRepository;
	private DirectoryRepository directoryRepository;
	private MusicRepository musicRepository;
	private PlaylistRepository playlistRepository;
	
	
	private boolean isPlaylist;
	private Playlist currentPlaylist;
	
	
	public PrincipalController() {
		this.isPlaying = false;
		this.isPlaylist = false;
		
		this.userRepository = UserRepository.getInstance();
		this.directoryRepository = DirectoryRepository.getInstance();
		this.musicRepository = MusicRepository.getInstance();
		this.playlistRepository = PlaylistRepository.getInstance();
	}

	@FXML
	private void initialize() {
		checkUserAuthorization();
		getSongsFromDirectories();
		showMusicsScrollPane();
		showPlaylistsScrollPane();

		labelNameUser.setAlignment(Pos.CENTER);
		labelNameUser.setText("Olá, " + userRepository.getAuthenticatedUser().getUsername());
	}

	private void checkUserAuthorization() {
		Usuario authenticatedUser = this.userRepository.getAuthenticatedUser();

		if (authenticatedUser.getRole().equals("2")) {
			buttonCriarUser.setVisible(false);
			scrollPaneDirectorys.setVisible(false);
			scrollPanePlaylists.setVisible(false);
			labelPlaylist.setVisible(false);
			labelNamePlaylist.setVisible(false);
			newPlaylistButton.setVisible(false);
		}
	}

	@FXML
	private void handlePlayPause() {
		if (isPlaying) {
			mediaPlayer.pause();
		} else {
			if (mediaPlayer == null) {
				wrongPlay.setText("Por favor, selecione a música.");
				return;
			}

			mediaPlayer.play();
			mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
				updateProgressBar();
			});
		}
	}

	@FXML
	void clickNextButton(ActionEvent event) {
		if (mediaPlayer == null) {
			wrongPlay.setText("Por favor, selecione a música.");
			return;
		}
		mediaPlayer.stop();

		Musica currentSong = getCurrentSong();
		ArrayList<Musica> musicas = musicRepository.getEntities();
		if(isPlaylist) {
			ArrayList<String> playlistSongs = getCurrentPlaylist().getMusicsName();
			musicas.removeIf(m -> !playlistSongs.contains(m.getNome()));
		}

		int currentIndex = musicas.indexOf(currentSong);
		// Verifique se é a última música da lista
		if (currentIndex == musicas.size() - 1) {
			// Se for a última música, volte para a primeira música
			setCurrentSong(musicas.get(0));
			File musicFile = new File(musicas.get(0).getCaminho());
			String audioFilePath = musicFile.toURI().toASCIIString();
			labelNameMusic.setText(musicas.get(0).getNome());
			playSong(audioFilePath, musicas.get(0).getNome());
		} else {
			// Caso contrário, toque a próxima música na lista
			setCurrentSong(musicas.get(currentIndex + 1));
			File musicFile = new File(musicas.get(currentIndex + 1).getCaminho());
			String audioFilePath = musicFile.toURI().toASCIIString();
			labelNameMusic.setText(musicas.get(currentIndex + 1).getNome());
			playSong(audioFilePath, musicas.get(currentIndex + 1).getNome());
		}
	}

	@FXML
	void clickPreviousButton(ActionEvent event) {
		if (mediaPlayer == null) {
			wrongPlay.setText("Por favor, selecione a música.");
			return;
		}
		mediaPlayer.stop();

		Musica currentSong = getCurrentSong();
		ArrayList<Musica> musicas = musicRepository.getEntities();
		if(isPlaylist) {
			ArrayList<String> playlistSongs = getCurrentPlaylist().getMusicsName();
			musicas.removeIf(m -> !playlistSongs.contains(m.getNome()));
		}

		int currentIndex = musicas.indexOf(currentSong);
		// Verifique se é a primeira música da lista
		if (currentIndex == 0) {
			setCurrentSong(musicas.get(musicas.size() - 1));
			// Se for a primeira música, vá para a última música da lista
			File musicFile = new File(musicas.get(musicas.size() - 1).getCaminho());
			String audioFilePath = musicFile.toURI().toASCIIString();
			playSong(audioFilePath, musicas.get(musicas.size() - 1).getNome());
		} else {
			// Caso contrário, toque a música anterior na lista
			setCurrentSong(musicas.get(currentIndex - 1));
			File musicFile = new File(musicas.get(currentIndex - 1).getCaminho());
			String audioFilePath = musicFile.toURI().toASCIIString();
			playSong(audioFilePath, musicas.get(currentIndex - 1).getNome());
		}
	}

	@FXML
	void clckResetButton(ActionEvent event) {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		} else {
			wrongPlay.setText("Por favor, selecione a música.");
			return;
		}
		File musicFile = new File(currentSong.getCaminho());
		String audioFilePath = musicFile.toURI().toASCIIString();
		playSong(audioFilePath, currentSong.getNome());
	}

	private void hyperlinkPlay(ActionEvent event) {
		
		setIsPlaylist(false);
		
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
		Hyperlink hyperlink = (Hyperlink) event.getSource();
		String musicName = hyperlink.getText();

		for (Musica musica : musicRepository.getEntities()) {
			if (musica.getNome().equals(musicName)) {
				// Reproduzir a música
				setCurrentSong(musica);
				File musicFile = new File(musica.getCaminho());
				String audioFilePath = musicFile.toURI().toASCIIString();
				playSong(audioFilePath, musica.getNome());

				break;
			}
		}
	}
	
	private void hyperlinkPlayPlaylist(ActionEvent event) {
		setIsPlaylist(true);
		
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
		Hyperlink hyperlink = (Hyperlink) event.getSource();
		String musicName = hyperlink.getText();

		for (Musica musica : musicRepository.getEntities()) {
			if (musica.getNome().equals(musicName)) {
				// Reproduzir a música
				setCurrentSong(musica);
				File musicFile = new File(musica.getCaminho());
				String audioFilePath = musicFile.toURI().toASCIIString();
				playSong(audioFilePath, musica.getNome());

				break;
			}
		}
	}
	
	private void hyperLinkSetPlaylist(ActionEvent event) {
		Hyperlink hyperlink = (Hyperlink) event.getSource();
		String playlistName = hyperlink.getText();
		labelNamePlaylist.setText(playlistName);
		
		VBox playlistSongsVbox = new VBox();
		
		Playlist playlist = this.playlistRepository.getPlaylistByName(this.userRepository.getAuthenticatedUser().getId(), playlistName);
		setCurrentPlaylist(playlist);
		
		for(String songString : playlist.getMusicas()) {
			String[] songData = songString.split(",");
			String songName = songData[0];
			String songPath = songData[1]; // <<< COnverter pra URI
			
			Musica localSong = new Musica(songName, songPath);
			
			Hyperlink songHyperlink = new Hyperlink(localSong.getNome());
			songHyperlink.setTextFill(Color.web("#6C63FF"));
			songHyperlink.setBorder(null);
			songHyperlink.setOnAction(this::hyperlinkPlayPlaylist); // Adiciona o evento de clique para reproduzir a música
			
			playlistSongsVbox.getChildren().add(songHyperlink);
		}
		scrollPaneDirectorys.setContent(playlistSongsVbox);
		
		styleSongsLabel();
	}

	private void playSong(String audioFilePath, String nameMusic) {
		
		wrongPlay.setText("");
		labelNameMusic.setText(nameMusic);
		Media media = new Media(audioFilePath);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setOnPaused(() -> {
			isPlaying = false;
			updatePlayButton();
		});
		mediaPlayer.setOnPlaying(() -> {
			isPlaying = true;
			updatePlayButton();
		});
		mediaPlayer.setOnEndOfMedia(() -> {
			isPlaying = false;
			updatePlayButton();
		});
		mediaPlayer.play();
		mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
			updateProgressBar();
		});
		
		styleSongsLabel();
		showMusicsScrollPane();
		showPlaylistsScrollPane();
	}

	private void styleSongsLabel() {
		if(this.scrollPaneDirectorys.getContent() != null && getCurrentSong() != null) {
			for(Node song : ((VBox)this.scrollPaneDirectorys.getContent()).getChildren()) {
				if(((Hyperlink)song).getText().equals(getCurrentSong().getNome()) && isPlaylist){
					song.setStyle("-fx-background-color: #FF6584;");
					continue;
				}
				song.setStyle("");
			}
		}
	}

	private void updatePlayButton() {
		Image iconImage;
		if (isPlaying)
			iconImage = new Image(getClass().getResourceAsStream("/br/ufrn/imd/icons/pause-solid.png"));
		else
			iconImage = new Image(getClass().getResourceAsStream("/br/ufrn/imd/icons/play-solid.png"));

		ImageView iconImageView = new ImageView(iconImage);
		iconImageView.setFitHeight(36.0);
		iconImageView.setFitWidth(24.0);
		playButton.setGraphic(iconImageView);
	}

	private void updateProgressBar() {
		Duration currentTime = mediaPlayer.getCurrentTime();
		Duration totalDuration = mediaPlayer.getTotalDuration();
		double progress = currentTime.toMillis() / totalDuration.toMillis();
		progressBar.setProgress(progress);
	}

	@FXML
	public void clickButtonCriarUser(ActionEvent event) {
		MainApp.changeScene("cadastro");
	}

	@FXML
	void clickButtonNewPlaylist(ActionEvent event) {
		MainApp.changeScene("novaplaylist");
	}

	@FXML
	private void addDirectoryClick(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(MainApp.stg);
		
		if (selectedDirectory != null) {
			Diretorio diretorio = new Diretorio(selectedDirectory.getAbsolutePath());
			this.directoryRepository.write(diretorio);
		}
		
		getSongsFromDirectories();
		showMusicsScrollPane();
	}

	@FXML
	void addFileClick(ActionEvent event) {
		try {
			FileChooser fileChooser = new FileChooser();
			File selectedFile = fileChooser.showOpenDialog(MainApp.stg);

			if (selectedFile != null) {
				if (!selectedFile.getName().contains(".mp3")) {
					Alert alert = new Alert(AlertType.WARNING, "Formato de arquivo inválido, aceitos: .mp3.");
					alert.showAndWait();
					return;
				}

				Musica song = new Musica(selectedFile.getName().replace(".mp3", ""), selectedFile.getPath());
				this.musicRepository.write(song);
				showMusicsScrollPane();
			}
		} 
		catch (Exception ex) {
			Alert alert = new Alert(AlertType.WARNING, ex.getMessage());
			alert.showAndWait();
		}
	}

	private void getSongsFromDirectories() {
		try {
			for (Diretorio directory : this.directoryRepository.getEntities()) {
				File dir = new File(directory.getPath());
				File[] files = dir.listFiles();
				for (File file : files) {
					if (!file.getName().contains(".mp3"))
						continue;

					Musica song = new Musica(file.getName().replace(".mp3", ""), file.getPath());
					this.musicRepository.write(song);
				}
			}
		} 
		catch (Exception ex) {
			Alert alert = new Alert(AlertType.WARNING, ex.getMessage());
			alert.showAndWait();
		}
	}

	private void showMusicsScrollPane() {
		if (this.userRepository.getAuthenticatedUser().getRole().equals("2")) {
			this.scrollPaneMusics.setMinWidth(100);
		}

		ArrayList<Musica> musicas = musicRepository.getEntities();
		VBox musicContainer = new VBox(); // VBox para armazenar os Hyperlinks das músicas

		for (Musica musica : musicas) {
			Hyperlink hyperlink = new Hyperlink(musica.getNome());
			hyperlink.setTextFill(Color.web("#6C63FF"));
			hyperlink.setBorder(null);
			hyperlink.setOnAction(this::hyperlinkPlay); // Adiciona o evento de clique para reproduzir a música

			if (getCurrentSong() != null && getCurrentSong().getNome() == musica.getNome() && !isPlaylist)
				hyperlink.setStyle("-fx-background-color: #FF6584;");

			musicContainer.getChildren().add(hyperlink);
		}

		scrollPaneMusics.setContent(musicContainer);
	}

	private void showPlaylistsScrollPane() {
		ArrayList<Playlist> userPlaylists = this.playlistRepository
				.getPlaylistsByUser(this.userRepository.getAuthenticatedUser().getId());

		VBox playlistContainer = new VBox();
		for (Playlist playlist : userPlaylists) {
			Hyperlink hyperlink = new Hyperlink(playlist.getNome());
			hyperlink.setTextFill(Color.web("#6C63FF"));
			hyperlink.setBorder(null);
			hyperlink.setOnAction(this::hyperLinkSetPlaylist); // Adiciona o evento de clique para reproduzir a música
			playlistContainer.getChildren().add(hyperlink);
		}

		scrollPanePlaylists.setContent(playlistContainer);
	}

	public Playlist getCurrentPlaylist() {
		return currentPlaylist;
	}

	public void setCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
	}

	public boolean getIsPlaylist() {
		return isPlaylist;
	}

	public void setIsPlaylist(boolean isPlaylist) {
		this.isPlaylist = isPlaylist;
	}

	private Musica getCurrentSong() {
		return currentSong;
	}

	private void setCurrentSong(Musica musica) {
		this.currentSong = musica;
	}
}
