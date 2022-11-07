package model;
import java.time.*;
public abstract class User{
    private String nickName;
    private LocalDate vinculationDate;
    private String identification;
    public User(String nickName,String identification){
        this.nickName = nickName;
        this.identification = identification;
        this.vinculationDate = LocalDate.now();
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public LocalDate getVinculationDate() {
        return vinculationDate;
    }
    public void setVinculationDate(LocalDate vinculationDate) {
        this.vinculationDate = vinculationDate;
    }
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    
}