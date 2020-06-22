package com.sicau.pojo;


public class User {

  private long uId;
  private long sId;
  private String uName;
  private String uPass;

  public User() {
  }

  public User(long uId, long sId, String uName, String uPass) {
    this.uId = uId;
    this.sId = sId;
    this.uName = uName;
    this.uPass = uPass;
  }

  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getUName() {
    return uName;
  }

  public void setUName(String uName) {
    this.uName = uName;
  }


  public String getUPass() {
    return uPass;
  }

  public void setUPass(String uPass) {
    this.uPass = uPass;
  }

  @Override
  public String toString() {
    return "User{" +
            "uId=" + uId +
            ", sId=" + sId +
            ", uName='" + uName + '\'' +
            ", uPass='" + uPass + '\'' +
            '}';
  }
}
