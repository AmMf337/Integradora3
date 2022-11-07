package model;

import java.util.ArrayList;

public class PremiumConsumer extends Consumer {
    
    public PremiumConsumer(String nickName,String identification){
        super(nickName, identification);
        boughtAudios = new ArrayList<AudioFile>();
        playLists = new ArrayList<PlayList>();
    }

    /**
     * Method addPlaylist this method receive an object of class playlist and add it to the playlist array of the user
     * @param newPlayList; object of class playlist that would be add.
     * @return msj String ; message informing if the playlist was added
     */
    @Override
    public String addPlayList(PlayList newPlayList) {
        playLists.add(newPlayList);
        String msj = "playlist añadida";
        return msj;
    }
}
