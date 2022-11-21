package model;
import java.time.*;

public class Song extends AudioFile implements sellAble,playAble {
    private double sellValue;
    private int numberOfsells;
    private String album;
    private MusicType genre;
    private String artistId;
    private LocalDate buyDate;
    public Song(String name,String url,double sellValue,String album,String artistId,int musicType,int minutes,int seconds){
        super(name, url,0,minutes,seconds);
        this.album = album;
        this.sellValue = sellValue;
        this.numberOfsells = 0;
        this.artistId = artistId;
        switch(musicType){
            case 1:
            this.genre = MusicType.ROCK;
                break;
            case 2:
            this.genre = MusicType.POP;
                break;
            case 3:
            this.genre = MusicType.HOUSE;
                break;
            case 4:
            this.genre = MusicType.TRAP;
                break;
        }
    }
    public void setNumberOfsells(int numberOfsells) {
        this.numberOfsells = numberOfsells;
    }
    public double getSellValue() {
        return sellValue;
    }
    public int getNumberOfsells() {
        return numberOfsells;
    }
    public String getAlbum() {
        return album;
    }
    public MusicType getGenre() {
        return genre;
    }
    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }
    public void increaseNumberOfsells() {
        this.numberOfsells += 1;
    }
    public String getArtistId() {
        return artistId;
    }
    public LocalDate getBuyDate() {
        return buyDate;
    }
    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }
    
    public void setGenre(MusicType genre) {
        this.genre = genre;
    }
    @Override
    public String sellThisSong(Consumer user) {
        Song songCopy = new Song(super.getName(), super.getUrl(), this.sellValue, this.album, this.artistId, 1, 0, 0);
        songCopy.setGenre(this.genre);
        songCopy.setDuration(this.getDuration());
        String msj = "No se encontro la cancion";
        boolean macth = false;
        for(int i = 0;i<((Consumer)(user)).getBoughtAudios().size() && !macth;i++){
            if(((Consumer)(user)).getBoughtAudios().get(i).getName()==songCopy.getName() && ((Consumer)(user)).getBoughtAudios().get(i).getArtistId()==songCopy.artistId){
                macth = true;
            }
        }
        if(macth==true){
            msj = "Este usuario ya compro esta cancion";
        }else{
            songCopy.setNumberOfReproductions(0);
            songCopy.setNumberOfsells(0);
            songCopy.setBuyDate(LocalDate.now());
            this.numberOfsells+=1;
            ((Consumer)(user)).getBoughtAudios().add(songCopy);
            msj = "Cancion comprada";
        }
        return msj;
    }
    @Override
    public String playThisAudio() {
        String msj = "nombre: " + super.getName() + "\n"+
                     "album: " + this.album + "\n"+
                     "genero: " + this.getGenre()+"\n"+
                     "duracion: "+this.getDuration()+"\n";
        super.increaseNumberOfReproductions();
        return msj;
    }
    
    
}
