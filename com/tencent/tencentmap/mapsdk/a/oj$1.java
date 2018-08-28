package com.tencent.tencentmap.mapsdk.a;

class oj$1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String[] b;
    final /* synthetic */ int c;
    final /* synthetic */ oj d;

    oj$1(oj ojVar, String str, String[] strArr, int i) {
        this.d = ojVar;
        this.a = str;
        this.b = strArr;
        this.c = i;
    }

    public void run() {
        oj.a(this.d, this.a, this.b, this.c);
    }
}
