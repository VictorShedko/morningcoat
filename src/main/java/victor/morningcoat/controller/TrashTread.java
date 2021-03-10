package victor.morningcoat.controller;

import java.util.concurrent.TimeUnit;

class Trash{
    private Integer i=3;
    private String str="lol";

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    protected void finalize(){

    }
}


public class TrashTread extends Thread {
    public void run(){
        Integer i=0;
        Trash trash;
        while (true){
            trash=new Trash();
            trash.setI(trash.getI()+i);
            i++;

            trash.setStr(trash.getStr()+i);

        }
    }

}
