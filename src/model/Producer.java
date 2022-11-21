package model;

public abstract class Producer extends User {
    private String url;
    private String name;
    private int reproductions;
    public Producer(String nickName,String identification,String url,String name){
        super(nickName, identification);
        this.name = name;
        this.url = url;
    }
    public int getReproductions() {
        return reproductions;
    }
    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }
    public void increaseNumberOfReproductions() {
        this.reproductions += 1;
    }
}
