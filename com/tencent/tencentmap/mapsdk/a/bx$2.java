package com.tencent.tencentmap.mapsdk.a;

class bx$2 implements Runnable {
    final /* synthetic */ bz a;
    final /* synthetic */ long b;
    final /* synthetic */ bx c;

    bx$2(bx bxVar, bz bzVar, long j) {
        this.c = bxVar;
        this.a = bzVar;
        this.b = j;
    }

    public void run() {
        this.a.g.a(this.a.a(), this.a.b(), this.b);
    }
}
