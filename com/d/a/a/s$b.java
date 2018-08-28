package com.d.a.a;

class s$b implements Runnable {
    final /* synthetic */ s bkj;
    final double bkk;
    final double bkl;
    final double bkm;
    final double bkn;
    final double bko;
    final double bkp;
    final double lat;
    final double lng;

    private s$b(s sVar, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this.bkj = sVar;
        this.lat = d;
        this.lng = d2;
        this.bkk = d3;
        this.bkl = d4;
        this.bkm = d5;
        this.bkn = d6;
        this.bko = d7;
        this.bkp = d8;
    }

    /* synthetic */ s$b(s sVar, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, byte b) {
        this(sVar, d, d2, d3, d4, d5, d6, d7, d8);
    }

    public final void run() {
        this.bkj.b(this.lat, this.lng, this.bkk, this.bkl, this.bkm, this.bkn, this.bko, this.bkp);
    }
}
