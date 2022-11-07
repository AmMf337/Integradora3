package model;

import java.util.ArrayList;

public abstract class Consumer extends User {
    ArrayList<AudioFile> boughtAudios;
    ArrayList<PlayList> playLists;
    public Consumer(String nickName,String identification){
        super(nickName, identification);
    }
    public abstract String addPlayList(PlayList newPlayList);
    /**
     * Method searchPlaylistByName;Compare the typed string with the registered playlist's names and if it is found
     * return it's position
     * @param name String; name of the wanted playlist
     * @return pos int; position of the wanted playlist,if it isn't found return -1.
     */
    public int searchPlaylistByName(String name){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0;!isFound;i++){
            if(playLists.get(i).getName().equalsIgnoreCase(name)){
                pos = i;
                isFound = true;
            }  
        }
        return pos;
    }
    public ArrayList<AudioFile> getBoughtAudios() {
        return boughtAudios;
    }
    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

}
