package com.example.limuzi.feiji;

public class Lianxi5 {
    final static double Pi = 3.1415926;

    public static void main(String[] args) {
        yuan a = new yuan(3.0);
        Spherical sp=new Spherical(4.0);

    }
}
     class yuan {
         double x, y;

         public yuan(double mj) {
             this.x = x;
             y = Lianxi5.Pi * mj * mj;
             System.out.println("园的面积是:" + y);
         }
     }
class Spherical{
            double x,y;
            public Spherical(double x){
                this.x=x;
                y=4/3*Lianxi5.Pi*x*x;
                System.out.println("球形的面积是:"+y);
            }
}

