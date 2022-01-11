package com.example.limuzi.feiji;

public class Jiekou  {

    public static void main(String[] args) {
        String a="我的天劫女友";
        Lianxi4 lx4=new Lianxi4(a);
        Lianxi4 lx5=new Lianxi4("你的名字");
        Lianxi4 lx6=new Lianxi4("天气之子");
        Lianxi4 lx7=new Lianxi4("烟花");
        lx5.start();
        lx4.start();
        lx6.start();
        lx7.start();

    }
}
