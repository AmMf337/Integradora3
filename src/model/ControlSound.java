package model;
import java.util.ArrayList;

public class ControlSound {
    private ArrayList<User> users;
    private ArrayList<AudioFile> audioFiles;
    public static final int ROWS = 6; 
    public static final int COLUMNS = 6;
    public ControlSound(){
        users = new ArrayList<User>(10);
        audioFiles = new ArrayList<AudioFile>(10);
        Song newSong1 = new Song("Another","qwerty",2000,"Queen forever",1,3,20);
        audioFiles.add(newSong1);
        Podcast newPodcast = new Podcast("Podcastinando", "kls", 1, "comedy podcast", 1, 30,20);
        audioFiles.add(newPodcast);
        StandarConsumer newUser = new StandarConsumer("ash", "20220");
        users.add(newUser);
    }
    /**
     * Method addConsumer:This method create and add to the arraylist of users an consumer user of the type choosen.
     * @param selection int; number that represent the type of consumer user choosen
     * @param nickName String; nickname of user
     * @param identification String; identification of user
     * @return msj String; message informing if the user was added.
     */
    public String addSConsumer(int selection,String nickName, String identification){
        String msj = "No se pudo agregar";
        StandarConsumer newConsumer = null;
        PremiumConsumer newPremium = null;
        switch(selection){
            case 1:
            newConsumer = new StandarConsumer(nickName, identification);
            if(users.add(newConsumer)){
                msj = "Se ha agregado al usuario estandar";
            }
                break;
            case 2: 
            newPremium = new PremiumConsumer(nickName, identification);
            if(users.add(newPremium)){
                msj = "Se ha agregado al usuario premium";
            }
                break;
        }
        return msj;
    }
    public ArrayList<AudioFile> getAudioFiles() {
        return audioFiles;
    }
    /**
     * Method addConsumer:This method create and add to the arraylist of users an producer user of the type choosen.
     * @param selection int; number that represent the type of consumer user choosen
     * @param nickName String; nickname of user
     * @param identification String; identification of user
     * @param url String; link of the perfil image of the user
     * @param name String; name of the user
     * @return msj String; message informing if the user was added.
     */
    public String addProducer(int selection,String nickName,String identification,String url,String name){
        String msj = "No se pudo agregar";
        User newUser = null;
        switch(selection){
            case 1:
            newUser = new Artist(nickName, identification, url, name);
            if(users.add(newUser)){
                msj = "Se ha agregado al artistas";
            }
                break;
            case 2:
            newUser =  new ContentCreator(nickName, identification, url, name);
            if(users.add(newUser)){
                msj = "Se ha agregado al usuario premium";
            }
                break;
        }
        return msj;
    }
    /**
     * Method searchUserByNickName;Receive and string with the name of the user and compare it with the registered user's name 
     * and return it's position if it is found
     * @param nickName; nickname of the wanted  user.
     * @return pos int; position of the wanted user,if it isn't found return -1.
     */
    public int searchUserByNickName(String nickName){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0;i<users.size() && !isFound;i++){
            if(users.get(i).getNickName().equalsIgnoreCase(nickName)){
                pos = i;
                isFound = true;
            }  
        }
        return pos;
    }
    /**
     * Method createPlayList; create an object of type playlist with the given parameters
     * @param playListName String; name of the playlist
     * @param selection int; number that represent the type of playlist choosen
     * @return  newPlaylist PlayList; the created playlist
     */
    public PlayList createPlayList(String playListName,int selection){
        PlayList newPlayList = new PlayList(playListName, selection);
        return newPlayList;
    }
    /**
     * Method searchAudioByName; search an audiofile by it's name and return it's position in the arrayList
     * @param name String; name of the wanted audiofile
     * @return pos int; position of the wanted object
     */
    public int searchAudioByName(String name){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0;i<audioFiles.size() && !isFound;i++){
            if(audioFiles.get(i).getName().equalsIgnoreCase(name)){
                pos = i;
                isFound = true;
            }  
        }
        return pos;
    }
    /**
     * Method addSong;Create and add an object of class song with the typed parameters in the audiofile arraylist.
     * @param name String; name of the song
     * @param url String;url of the song's cover
     * @param sellValue double ; sales value of song
     * @param album String; album of the song
     * @param musicType int;represent the election for the genre of the song
     * @param minutes int; minutes of duration of song
     * @param seconds int; seconds of duration of the song beside the exactly minutes
     * @return msj String; message informing if the song was added
     */
    public String addSong(String name,String url,double sellValue,String album,int musicType,int minutes,int seconds){
        String msj = "La cancion no pudo ser agregada";
        Song newSong = new Song(name, url, sellValue, album, musicType, minutes, seconds);
        if(audioFiles.add(newSong)){
            msj = "La cancion fue agregada";
        }
        return msj;
    }
     /**
    * Method verifyNickName:Verify that the nickname of the use is not in use.
    * @param nickPlayer nick name of user
    * @return return a boolean that indicate if there was a coincidece with the nickname
    */
    public boolean verifyNickName(String nickName){
        boolean macth = false;
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getNickName().equals(nickName)){
                 macth= true;
            }
        }
        return macth;
     }
    /**
     * Method addPodcast; Create and add an object of class Podcast with the typed parameters in the audiofile arraylist.
     * @param name String; Name of podcast
     * @param url String; url of the podcas's cover
     * @param category int; number that represent the category of the podcast
     * @param description String; description of podcast
     * @param hours int; hours of duration of podcast
     * @param minutes int; minutes of duration of podcast beside the exact hours
     * @param seconds int; seconds of duration of podcast beside the exact minutes
     * @return msj String; message informing if the podcast was added
     */
    public String addPodcast(String name,String url,int category,String description,int hours,int minutes,int seconds){
        String msj = "El podcast no pudo ser agregado";
        Podcast newPodcast = new Podcast(name, url,category, description, hours, minutes, seconds);
        if(audioFiles.add(newPodcast)){
            msj = "El podcast fue agregado";
        }
        return msj;
    }
    /**
     * Method generateShareCodeForPlayList;Based on the type of a playlist generate a code in base to a ramdom generated mold
     * @param type PlayListType; the type of the playList
     * @return  msj String; message with the mold
     */
    public String generateShareCodeForPlayList(PlayListType type){
        int[][] matrix = new int[6][6];
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;
        String msj = "";
        for(int i = 0;i<ROWS;i++){
            for(int j = 0;j<COLUMNS;j++){
                matrix[i][j] = (int)(Math.random()*range)+lowerBound;
            }
        }
        
        for(int i = 0; i <ROWS; i++){
            msj += "\n"; 
            for(int j = 0; j <COLUMNS; j++){
                msj += matrix[i][j] + " ";
            }
        }
        msj += "\n"+
                "Codigo de acceso:\n";
        switch(type){
            case SONGS:
            //just songs
           for(int i = 5;i>=0;i--){
                msj += matrix[i][0];
            }
            for(int i = 1;i<ROWS;i++){
                for(int j = 1; j <COLUMNS; j++){
                    if(i==j){
                        msj += matrix[i][j];
                    }
                }
            }
            for(int i = 4;i>=0;i--){
                msj += matrix[i][5];
            }
                break;
            case PODCASTS:
            //just podcast
            for(int i=0;i<=2;i++){
                msj += matrix[0][i];
            }
            for(int i=1;i<ROWS;i++){
                msj += matrix[i][2];
            }
            for(int i=5;i>=0;i--){
                msj += matrix[i][3];
            }
            for(int i=4;i<=5;i++){
                msj += matrix[0][i];
            }
                break;
            case SONGS_AND_PODCASTS:
            //Podcast and songs
            for(int i = 4;i>=0;i--){
                if(i%2==0){
                    msj += matrix[5][i];
                }
            }
            for(int i = 5;i>=0;i--){
                if(i%2!=0){
                    msj += matrix[4][i];
                }
            }
            for(int i = 4;i>=0;i--){
                if(i%2==0){
                    msj += matrix[3][i];
                }
            }
            for(int i = 5;i>=0;i--){
                if(i%2!=0){
                    msj += matrix[2][i];
                }
            }
            for(int i = 4;i>=1;i--){
                if(i%2==0){
                    msj += matrix[1][i];
                }
            }
            for(int i = 5;i>=3;i--){
                if(i%2!=0){
                    msj += matrix[0][i];
                }
            }
                break;
        }
        
        return msj;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
}
