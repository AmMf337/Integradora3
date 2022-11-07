package model;

public class Podcast extends AudioFile{
    private PodcastCategory category;
    private String description;
    public Podcast(String name,String url,int category,String description,int hours,int minutes,int seconds){
        super(name, url,hours,minutes,seconds);
        this.description = description;
        switch(category){
            case 1:
            this.category = PodcastCategory.ENTERTAIMENT;
                break;
            case 2:
            this.category = PodcastCategory.FASHION;
                break;
            case 3:
            this.category = PodcastCategory.POLITICS;
                break;
            case 4:
            this.category = PodcastCategory.VIDEOGAMES;
                break;
        }
    }
}