package com.example.limuzi.utils;

import java.util.ArrayList;
import java.util.List;

public class SetList {

    public static void main(String[] args) {
        int a[]= new int[5];
        int[] a1=new int[]{0,1,2,3,4,5};
        int[] a2={0,1,2,3,4,5};
        int ii=2;
        int ii1=++ii;
        int ii2=ii++;
        System.out.println("++i的值为："+ii1+","+"i++的值为："+ii2);

        List<String> list=new ArrayList<String>();
        for (int i=0;i<10;i++){
            int a3 = i;
            list.add(String.valueOf(a3));
        }
        System.out.println(list);
        list.remove(3);
        String tep="小舞";
        list.add(8,tep);
        System.out.println(list);
        for (int i=0;i<list.size()-4;i++){
            if (list.get(i).equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
