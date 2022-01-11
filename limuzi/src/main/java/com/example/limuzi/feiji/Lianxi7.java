package com.example.limuzi.feiji;

public class Lianxi7 extends Lianxi6{
    public Lianxi7(String screen){
        super();
        this.screen=super.screen;
    }
    public static void main(String[] args) {
      Lianxi7.a();
      Lianxi7 lianxi7=new Lianxi7("李玄子");
       lianxi7.b("李玄子");

    }
    public  String b(String screen){
        this.screen=super.screen;
        System.out.println(super.screen);
        return "";
    }
    public static void a(){
        System.out.println("nihao");
    }

}
