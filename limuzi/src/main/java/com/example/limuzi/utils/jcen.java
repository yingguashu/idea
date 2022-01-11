package com.example.limuzi.utils;

public class jcen extends MD5Utils{

    public static String md5(String string) throws RuntimeException{
        String cc="小舞";
        System.out.println(cc);
        return cc;
    }
    public static boolean z(){
        return true;
    }
    public static String az(){
        System.out.println("李玄子");
        return "";
    }

    public static void main(String[] args) {
        MD5Utils b = new MD5Utils();
        System.out.println(md5(""));
        if (z() == false){
            System.out.println("这是真");
        }else {
            System.out.println("这是假");
        }
        jcen.az();
    }
}
