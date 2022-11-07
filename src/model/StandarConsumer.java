package model;

import java.util.ArrayList;

public class StandarConsumer extends Consumer{
    private final int MAX_SONGS = 100; 
    private final int MAX_Playlist = 20;
    public StandarConsumer(String nickName, String identification) {
        super(nickName, identification);
        boughtAudios = new ArrayList<AudioFile>(100);
        playLists = new ArrayList<PlayList>(20);
    }
   
    /**
     * Method addPlaylist this method receive an object of class playlist and add it to the playlist array of the user
     * @param newPlayList; object of class playlist that would be add.
     * @return msj String ; message informing if the playlist was added
     */
    @Override
    public String addPlayList(PlayList newPlayList) {
        String msj = "Capacidad maxima alcanzada";
        if(playLists.size()<MAX_Playlist){
            playLists.add(newPlayList);
            msj = "playlist añadida";
        }
        return msj;
    }

}
