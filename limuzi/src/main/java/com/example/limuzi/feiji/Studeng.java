package com.example.limuzi.feiji;

import java.util.Scanner;

public class Studeng {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        String str = "(13[0-9]|15[012356789]|18[056789])+\\d{8}";
        int a=1;
        do {
            System.out.println("请输入你的手机号");
            String yx=sc.nextLine();
            if (yx.matches(str)) {
                System.out.println(yx + "是正确的手机号");
                a++;
            } else {
                System.out.println(yx + "不是正确的手机号,请再次输入");
            }
        }while (!(a==2));
    }
}
