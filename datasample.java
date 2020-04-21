package com.example.realtime;

class datasample {

    private Integer serial ;
    private String state ;
    private Integer confirmed ;
    private Integer cured ;
    private  Integer death ;

    public String getState() {
        return state;
    }

    public Integer getSerial(int i) {
        return serial;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public Integer getCured() {
        return cured;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death=death;
    }

    public void setCured(int cured) {
        this.cured=cured ;
    }

    public void setState(String state) {
          this.state =state ;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed=confirmed;
    }

    @Override
    public String toString() {
        return "datasample{" +
                "serial=" + serial +
                ", state='" + state + '\'' +
                ", confirmed=" + confirmed +
                ", cured=" + cured +
                ", death=" + death +
                '}';
    }
}
