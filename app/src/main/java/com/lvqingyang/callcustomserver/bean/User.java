package com.lvqingyang.callcustomserver.bean;

/**
 * Author：LvQingYang
 * Date：2017/9/2
 * Email：biloba12345@gamil.com
 * Github：https://github.com/biloba123
 * Info：
 */
public class User {


    /**
     * ServerID : 100003
     * Username : hezepeng
     * Password : 123456
     * Phone : 18696162662
     * IdCard : 420922199610164632
     * Name : 何泽鹏
     * Email : hezepeng96@163.com
     * RegisterTime : 2017-07-30T16:31:53.147
     * Balance : 0.0
     * Nickname : null
     * Score : 0.0
     * WaittingBalance : 0
     */

    private int ServerID;
    private String Username;
    private String Password;
    private String Phone;
    private String IdCard;
    private String Name;
    private String Email;
    private String RegisterTime;
    private double Balance;
    private String Nickname;
    private double Score;
    private String WaittingBalance;

    public int getServerID() {
        return ServerID;
    }

    public void setServerID(int ServerID) {
        this.ServerID = ServerID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String IdCard) {
        this.IdCard = IdCard;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRegisterTime() {
        return RegisterTime;
    }

    public void setRegisterTime(String RegisterTime) {
        this.RegisterTime = RegisterTime;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }

    public String getWaittingBalance() {
        return WaittingBalance;
    }

    public void setWaittingBalance(String WaittingBalance) {
        this.WaittingBalance = WaittingBalance;
    }
}
