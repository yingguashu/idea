package com.example.limuzi.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lianxi {

    private String name;
    private String password;
    public lianxi(String name, String password){
        this.name=name;
        this.password=password;
    }

    public String toString(){
        return name+":"+password;
    }

    public static void main(String[] args) {
        lianxi a =new lianxi("小舞","123456");
        System.out.println(a);
        a.b();
        a.getvalue();
        lianxi.c();
        int[] arr = {1,5,9,8,18,6,5,21,14};
        int[] f=maxArr(arr);
        System.out.println("最大值为:"+f[0]);
        System.out.println("最大值下标为:"+f[1]);

    }
    public static int[] maxArr(int[] arr){
        int maxValue=arr[0];
        int[] arr1=new int[2];
        int b=0;
        for (int i=0;i!=arr.length;i++){
            if(maxValue<arr[i]){
                maxValue=arr[i];
                b=i;
            }
        }
        arr1[0]=maxValue;
        arr1[1]=b;
        return arr1;
    }
    public List<String> getvalue(){
        List<String> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list.add("李沐子");
        list.add("李玄子");
        list.add("涂山雅雅");
        list.add("涂山容容");
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        for (Integer ac:list1){
            System.out.print("这是第"+ac+"次");
            System.out.print("  "+ac+"  ");
        }
        System.out.println("-----------------");
        list.add(4,"东方月初");
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        return list;
    }

    public void b(){
        System.out.println("这是一个普通的方法b");
    }
    public static void c(){
        System.out.println("这是一个静态的方法:");
    }
}
