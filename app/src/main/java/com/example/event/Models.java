package com.example.event;

public class Models {
    private int im;
    private String des;
    private String ti;

    public int getIm() {
        return im;
    }

    public void setIm(int im) {
        this.im = im;
    }
    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti;
    }


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }



    public Models(int im, String des, String ti) {
        this.im = im;

        this.ti = ti;
        this.des = des;
    }
}



