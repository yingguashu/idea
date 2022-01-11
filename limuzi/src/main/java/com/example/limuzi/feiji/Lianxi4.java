package com.example.limuzi.feiji;

public class Lianxi4 extends Thread {
    private String name;
    static int cepiao=100;
    int a=0;

    //创建一个锁对象
    static Object obj=new Object();
    public  Lianxi4(String name){
        this.name=name;
    }

    public void run(){
        while(true){
            synchronized (obj){
                if (cepiao>0){
                    System.out.println(name+"卖出的票数是"+(cepiao--));
                    a++;
                }else {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("结束《"+name+"》卖出了"+a);
    }

//    @Override
//    public void run() {
//        for (int i=1;i<101;i++){
//            System.out.println("《"+name+"》"+"下载%"+i);
//            try {
//                Thread.sleep(1000);
//                System.out.println(name+"停止了一秒钟");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
