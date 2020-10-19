package br.edu.dmos5.myyoutube.activity;

import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import br.edu.dmos5.myyoutube.R;
import br.edu.dmos5.myyoutube.helper.YoutubeConfig;

public class PlayerActivity extends YouTubeBaseActivity
             implements YouTubePlayer.OnInitializedListener { // Implementamos a interface com os dois metodos que serao utilizados

    private YouTubePlayerView youTubePlayerView; // Criamos a Referencia para o YoutubePlayerView
    private String idVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //Configura componentes
        youTubePlayerView = findViewById(R.id.playerVideo);

        Bundle bundle = getIntent().getExtras();
        if( bundle != null ){
            idVideo = bundle.getString("idVideo");// Aqui iniciamos o player
            youTubePlayerView.initialize(YoutubeConfig.CHAVE_YOUTUBE_API, this); // Aqui inicializamos o player para que ele possa ser executado
        }

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {// Passamos os 3 parametros que estão na documentação.
        //sucesso ao inciar o player. Executamos o video
        youTubePlayer.setFullscreen(true);
        youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.loadVideo( idVideo ); // Metodo que carrego o Video do youtube

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {


    }
}
