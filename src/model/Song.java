package model;

public class Song extends AudioFile {
    private double sellValue;
    private int numberOfsells;
    private String album;
    private MusicType genre;
    public Song(String name,String url,double sellValue,String album,int musicType,int minutes,int seconds){
        super(name, url,0,minutes,seconds);
        this.album = album;
        this.sellValue = sellValue;
        this.numberOfsells = 0;
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
    public void setNumberOfsells(int numberOfsells) {
        this.numberOfsells = numberOfsells;
    }
    
    
}
