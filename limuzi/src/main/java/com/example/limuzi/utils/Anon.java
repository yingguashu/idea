package com.example.limuzi.utils;

public class Anon {
    public static void main(String[] args) {
        intro a =new intro() {
            @Override
            public void menth() {
                System.out.println("匿名内部类");
            }
        };
        a.menth();
    }
}
interface intro{
    void menth();
}
