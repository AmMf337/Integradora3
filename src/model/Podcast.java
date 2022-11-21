package model;

public class Podcast extends AudioFile implements playAble{
    private PodcastCategory category;
    private String description;
    private String creatorId;
    public Podcast(String name,String url,int category,String description,String creatorId,int hours,int minutes,int seconds){
        super(name, url,hours,minutes,seconds);
        this.description = description;
        this.creatorId = creatorId;
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
    @Override
    public String playThisAudio() {
        String msj = "nombre: "+this.getName()+"\n"+
                    "categoria: "+ this.category+"\n"+
                    "descripcion: "+this.description+"\n"+
                    "duracion: "+this.getDuration();
        increaseNumberOfReproductions();
        return msj;
    }
}