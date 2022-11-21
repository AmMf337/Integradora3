package model;
import java.util.ArrayList;

public class ControlSound {
    private ArrayList<User> users;
    private ArrayList<AudioFile> audioFiles;
    private ArrayList<Advertisment> ads;
    public static final int ROWS = 6; 
    public static final int COLUMNS = 6;
    public ControlSound(){
        users = new ArrayList<User>(10);
        audioFiles = new ArrayList<AudioFile>(10);
        ads = new ArrayList<Advertisment>();
        Podcast newPodcast = new Podcast("Podcastinando", "kls", 1, "comedy podcast","2", 1, 30,20);
        newPodcast.setNumberOfReproductions(100);
        audioFiles.add(newPodcast);
        StandarConsumer newUser = new StandarConsumer("ash", "20220");
        users.add(newUser);
        Artist newArtist = new Artist( "b", "er", "12", "df");
        users.add(newArtist);
        Song newSong1 = new Song("Another","qwerty",2000,"Queen forever","er",1,3,20);
        newSong1.setNumberOfReproductions(100);
        audioFiles.add(newSong1);
        Song newSong2 =new Song("b", "d", 3000, "af", "er", 2, 3, 3);
        audioFiles.add(newSong2);
        ContentCreator newCreator = new ContentCreator("qwe", "3", "1","a.man");
        users.add(newCreator);
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
    public void initAds(){
        Advertisment ad1 = new Advertisment("Nike", "just do it");
        ads.add(ad1);
        Advertisment ad2 = new Advertisment("Coca Cola", "Open happines");
        ads.add(ad2);
        Advertisment ad3 = new Advertisment("M&M", "Melts in Your Mouth, Not in Your Hands");
        ads.add(ad3);
    }
    public ArrayList<AudioFile> getAudioFiles() {
        return audioFiles;
    }
    public boolean verifyAudiofileName(String name){
        boolean macth = false;
        for(int i = 0; i<audioFiles.size();i++){
            if(audioFiles.get(i).getName().equalsIgnoreCase(name)){
                 macth= true;
            }
        }
        return macth;
    }
    public boolean verifyArtistId(String id){
        boolean macth = false;
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getIdentification().equals(id) && users.get(i) instanceof Artist){
                 macth= true;
            }
        }
        return macth;
    }
    public boolean verifyCreatorId(String id){
        boolean macth = false;
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getIdentification().equals(id) && users.get(i) instanceof ContentCreator){
                 macth= true;
            }
        }
        return macth;
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
    public int searchUserById(String userId){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0;i<users.size() && !isFound;i++){
            if(users.get(i).getIdentification().equalsIgnoreCase(userId)){
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
    public String addPlayListToUser(String userName,String playListName,int selection,String userNickName){
        PlayList newPlayList = new PlayList(playListName, selection);
        int pos = searchUserByNickName(userNickName);
        String msj = "No se creo la playList";
        if(pos!=-1 && users.get(pos) instanceof Consumer){
            ((Consumer)(users.get(pos))).addPlayList(newPlayList);
            msj = "Se agrego la playlist";
        }
        return msj;
    }
    public String addAudioToPlayList(String userNicKName,String audioName,String playListName){
        int pos = searchUserByNickName(userNicKName);
        int playlisTpos = -1;
        int audioPos = -1;
        AudioFile audioFileToadd = null;
        String msj = "No se pudo encontrar al usuario";
        if(pos != -1 && users.get(pos) instanceof Consumer){
            if(((Consumer)((users.get(pos)))).searchPlaylistByName(playListName)!=-1){
                playlisTpos = ((Consumer)((users.get(pos)))).searchPlaylistByName(playListName);
                if(((Consumer)((users.get(pos)))).searchAudioByName(audioName)!=-1){
                    audioPos = ((Consumer)((users.get(pos)))).searchAudioByName(audioName);
                    audioFileToadd = ((Consumer)((users.get(pos)))).getBoughtAudios().get(audioPos);
                    msj = ((Consumer)((users.get(pos)))).getPlayLists().get(playlisTpos).addAudio(audioFileToadd);
                }else{
                    msj = "no se encontro archivo de audio para agregar";
                }
            }else{
                msj = "no se encontro la playList";
            }
        }
       return msj;
    }
    public String removeAudioOfPLayList(String userNicKName,String audioName,String playListName){
        int pos = searchUserByNickName(userNicKName);
        int playlisTpos = -1;
        String msj = "No se pudo encontrar al usuario";
        if(pos != -1 && users.get(pos) instanceof Consumer){
            if(((Consumer)((users.get(pos)))).searchPlaylistByName(playListName)!=-1){
                playlisTpos = ((Consumer)((users.get(pos)))).searchPlaylistByName(playListName);
                if(((Consumer)((users.get(pos)))).searchAudioByName(audioName)!=-1){
                    msj = ((Consumer)((users.get(pos)))).getPlayLists().get(playlisTpos).deleteAudio(audioName);;
                }else{
                    msj = "no se encontro archivo de audio para agregar";
                }
            }else{
                msj = "no se encontro la playList";
            }
        }
       return msj;
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
    public String addSong(String name,String url,double sellValue,String album,String artistId,int musicType,int minutes,int seconds){
        String msj = "La cancion no pudo ser agregada";
        Song newSong = new Song(name, url, sellValue, album,artistId, musicType, minutes, seconds);
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
     public boolean verifyId(String id){
        boolean macth = false;
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getIdentification().equals(id)){
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
    public String addPodcast(String name,String url,int category,String description,String creatorId,int hours,int minutes,int seconds){
        String msj = "El podcast no pudo ser agregado";
        Podcast newPodcast = new Podcast(name, url,category, description,creatorId, hours, minutes, seconds);
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
    public String BuyASong(String userNickName,String songName){
        int userPos = searchUserByNickName(userNickName);
        int songPos = searchAudioByName(songName);
        String msj = "Usuario no encontado";
        if( userPos != -1 && users.get(userPos) instanceof Consumer){
            if(songPos != -1 && audioFiles.get(songPos) instanceof Song){
                msj = ((Song)(audioFiles.get(songPos))).sellThisSong(((Consumer)(users.get(userPos))));
            }else{
                msj = "la cancion no fue comprada o es un archivo de audio que no se puedde comprar";
            }
        }else{
            msj = "el usario no fue encontrado o no es un usuario consumidor";
        }
        
        return msj;
    }
    public String playAudio(String userNickName,String songName){
        int pos = searchUserByNickName(userNickName);
        int audioPos = 0;
        int artistPos = 0;
        String msj = "Usuario no encontado";
        String artisId = "";
        if(pos != -1 && users.get(pos) instanceof Consumer){
            audioPos = ((Consumer)(users.get(pos))).searchAudioByName(songName);
            if(audioPos != -1){
                msj = ((Consumer)(users.get(pos))).getBoughtAudios().get(audioPos).playThisAudio();
                artisId = ((Consumer)(users.get(pos))).getBoughtAudios().get(audioPos).getArtistId();
                artistPos = searchUserById(artisId);
                audioFiles.get(searchAudioByName(songName)).increaseNumberOfReproductions();
                ((Producer)(users.get(artistPos))).increaseNumberOfReproductions();
                msj += "artist: "+((Producer)(users.get(artistPos))).getNickName();
                    
            }else{
                msj = "la canción no fue encontada,puede que aun no haya sido comprada";
            }
        }
        return msj;
    }
    public String playAnAd(){
        int upperBound = 2;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;
        Advertisment ad = ads.get((int)(Math.random()*range)+lowerBound);
        String msj = "Anuncio"+"\n"+
                    "Title: "+ ad.getTitle()+"\n"+
                    "Description: "+ ad.getDescription()+"\n";
        return msj;
    }
    public String getTotalReproductionsForAudioFileType(){
        String msj = "";
        int totalSongReproductions = 0;
        int totalPodcastReproductions = 0;
		for(int i = 0;i<audioFiles.size();i++){
            if(audioFiles.get(i) instanceof Song){
                totalSongReproductions += audioFiles.get(i).getNumberOfReproductions();
            }
		}
        msj = "El numero total de reproducciones de canciones es " + totalSongReproductions +"\n";
        for(int i = 0;i<audioFiles.size();i++){
            if(audioFiles.get(i) instanceof Podcast){
                totalPodcastReproductions += audioFiles.get(i).getNumberOfReproductions();
            }
        }
        msj += "el numero total de reproducciones de podcast es " + totalPodcastReproductions;
        return msj;
	}
    public String getMostListenGenre(){
        int rock = 0;
        int pop = 0;
        int house = 0;
        int trap = 0;
        for(int i = 0;i<audioFiles.size();i++){
            if(audioFiles.get(i) instanceof Song){
                switch(((Song)(audioFiles.get(i))).getGenre()){
                    case ROCK:
                    rock += audioFiles.get(i).getNumberOfReproductions();
                    break;
                    case POP:
                    pop += audioFiles.get(i).getNumberOfReproductions();
                    break;
                    case HOUSE:
                    house += audioFiles.get(i).getNumberOfReproductions();
                    break;
                    case TRAP:
                    trap += audioFiles.get(i).getNumberOfReproductions();
                    break;
                }
            }
		}
        return "";
    }
}
