package model;

public abstract class Producer extends User {
    private String url;
    private String name;
    public Producer(String nickName,String identification,String url,String name){
        super(nickName, identification);
        this.name = name;
        this.url = url;
    }
}
