package model;

import java.util.ArrayList;

public abstract class Consumer extends User {
    ArrayList<Song> boughtAudios;
    ArrayList<PlayList> playLists;
    private int reproductionsPolitics;
    private int reproductionsEntertaiment;
    private int reproductionsVideoGames;
    private int reproductionsFashion;
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
    public ArrayList<Song> getBoughtAudios() {
        return boughtAudios;
    }
    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }
    public int searchAudioByName(String name){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0;i<boughtAudios.size() && !isFound;i++){
            if(boughtAudios.get(i).getName().equalsIgnoreCase(name)){
                pos = i;
                isFound = true;
            }  
        }
        return pos;
    }
    public boolean addSong(Song boughtSong){
        return boughtAudios.add(boughtSong);
    }

    public String getMostListenGenre(){
        MusicType songGenre  = null;
        int rock = 0;
        int pop = 0;
        int house = 0;
        int trap = 0;
        
        for(int i = 0;i<boughtAudios.size();i++){
            songGenre = boughtAudios.get(i).getGenre();
            switch(songGenre){
                case ROCK:
                rock += boughtAudios.get(i).getNumberOfReproductions();
                    break;
                case POP:
                pop += boughtAudios.get(i).getNumberOfReproductions();
                    break;
                case HOUSE:
                house += boughtAudios.get(i).getNumberOfReproductions();
                    break;
                case TRAP:
                trap += boughtAudios.get(i).getNumberOfReproductions();
                    break;
            }
        }
        return "";
    }
    public void increaseReproductionOfPodcastCategory(PodcastCategory podcastCategory){
        switch(podcastCategory){
            case ENTERTAIMENT:
            reproductionsEntertaiment += 1;
            break;
            case FASHION:
            reproductionsFashion += 1;
            break;
            case VIDEOGAMES:
            reproductionsVideoGames += 1;
            break;
            case POLITICS:
            reproductionsPolitics += 1;
        }
    }

}
