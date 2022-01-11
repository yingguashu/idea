package com.example.limuzi.utils;

public interface Polygin {
    public void dispaly();
}

class Andia{
    public void cread(){
        Polygin p1 = new Polygin() {
            @Override
            public void dispaly() {
                System.out.println("匿名类成功");
            }
        };
        p1.dispaly();
    }
}

class Main{
    public static void main(String[] args) {
        Andia a = new Andia();
        a.cread();
    }
}
