package com.example.limuzi.feiji;

public class Lianxi6 {
    String screen="液晶显示器";
    public static void main(String[] args) throws ClassNotFoundException {
        Class cl=Class.forName("Hellow");
        try {
            Lianxi7 lx7=(Lianxi7)cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
