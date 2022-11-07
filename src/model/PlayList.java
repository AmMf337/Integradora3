package model;

import java.util.ArrayList;

public class PlayList {
    private ArrayList<AudioFile> playlistElements;
    private String name;
    private PlayListType type;
    public PlayList(String name,int selection){
        this.name = name;
        playlistElements = new ArrayList<AudioFile>();
        switch(selection){
            case 1:
            type = PlayListType.SONGS;
                break;
            case 2:
            type = PlayListType.PODCASTS;
                break;
            case 3:
            type = PlayListType.SONGS_AND_PODCASTS;
                break;
        }
    }
    public PlayListType getType() {
        return type;
    }
    /**
     * Method addAudio;Receive an object of class audioFile and it is added to the audiofile's arraylist of the playlist
     * @param newAudio AudioFile; object to be added
     * @return msj String; message informing if the object was added
     */
    public String addAudio(AudioFile newAudio){
        String msj = "";
        if(type == PlayListType.SONGS){
            if(newAudio instanceof Song){
                playlistElements.add(newAudio);
                msj = "cancion anadida";
            }else{
                msj = "Esta playlist solo es de canciones";
            }
        }else if(type == PlayListType.PODCASTS){
            if(newAudio instanceof Podcast){
                playlistElements.add(newAudio);
                msj = "cancion anadida";
            }else{
                msj = "Esta playlist solo es de podcast";
            }
        }else if(type == PlayListType.SONGS_AND_PODCASTS){
            playlistElements.add(newAudio);
            msj = "audio anadido";
        }
        return msj;
    }
    public ArrayList<AudioFile> getPlaylistElements(){
        return playlistElements;
    }
    public String getName(){
        return name;
    }
    
}
