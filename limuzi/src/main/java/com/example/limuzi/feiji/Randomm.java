package com.example.limuzi.feiji;

import java.util.Random;
import java.util.Scanner;

public class Randomm {
    public static void main(String[] args) {
        Random random=new Random();
        System.out.println(random.nextInt(10));
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的红包金额：");
        double money=sc.nextDouble();
        System.out.println("请输入你要分配的份数：");
        int share =sc.nextInt();
        double min=0.01;
        for (int i=1;i<share;i++){
            double max=money-(min*(share-i));//本次最大金额

            double bound=max-min;//本次可发出的总金额
            //随机金额
            double safe=(double)random.nextInt((int)bound*100)/100;
            //本次发出去的金额
            double money1=safe+min;
            //总钱数
            money=money-money1;
            System.out.println("第"+i+"个红包的金额"+String.format("%.2f",money1)+"元");
        }
        System.out.println("最后一个红包是"+String.format("%.2f",money)+"元");
        sc.close();
    }
}
