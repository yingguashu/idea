package com.example.limuzi.utils;


import java.util.Scanner;

public class Lianxi1 {
    int lianxiAge=10;
    public  Lianxi1(String name){
        System.out.println("输出:"+name);

    }

    public static void main(String[] args) {
        Scanner aa=new Scanner(System.in);
        System.out.println("请输入:");
        Integer ab=aa.nextInt();
        Lianxi1 lian = new Lianxi1("成功");
        System.out.println("第一次输出为："+lian.setAge(ab));
        System.out.println("第二次输出为："+lian.lianxiAge);
    }

    public int setAge(int age){
//        lianxiAge=age;
        return age;
    }
    public int getAge(){
        System.out.println("数字为："+lianxiAge);
        return lianxiAge;
    }
}
