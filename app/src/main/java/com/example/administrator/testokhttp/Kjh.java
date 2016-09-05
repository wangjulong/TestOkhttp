package com.example.administrator.testokhttp;


import com.orm.SugarRecord;

/**
 * Created by Administrator on 2016/9/5.
 */


class Kjh extends SugarRecord{
    String title;

    int n1;
    int n2;
    int n3;
    int n4;
    int n5;

    public Kjh() {
    }

    Kjh(String title, int n1, int n2, int n3, int n4, int n5) {
        this.title = title;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
    }

}