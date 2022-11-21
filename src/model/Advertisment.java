package model;

public class Advertisment {
    private String title;
    private String description;
    public Advertisment(String title,String description){
        this.title = title;
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
