package model;

import java.time.LocalTime;

public class AudioFile {
    private String name;
    private String url;
    private LocalTime duration;
    private int numberOfReproductions;
    private LocalTime purchaseDate;
    public AudioFile(String name,String url,int hours,int minutes,int seconds){
        this.name = name;
        this.url = url;
        this.duration = LocalTime.of(hours,minutes,seconds);
        this.numberOfReproductions = 0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public LocalTime getDuration() {
        return duration;
    }
    public int getNumberOfReproductions() {
        return numberOfReproductions;
    }
    public void setNumberOfReproductions(int numberOfReproductions) {
        this.numberOfReproductions = numberOfReproductions;
    }
    
}
