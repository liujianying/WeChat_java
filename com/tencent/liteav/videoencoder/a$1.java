package com.tencent.liteav.videoencoder;

class a$1 implements Runnable {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ TXSVideoEncoderParam b;
    final /* synthetic */ a c;

    a$1(a aVar, boolean[] zArr, TXSVideoEncoderParam tXSVideoEncoderParam) {
        this.c = aVar;
        this.a = zArr;
        this.b = tXSVideoEncoderParam;
    }

    public void run() {
        if (this.c.mInit) {
            a.a(this.c);
        }
        this.a[0] = a.a(this.c, this.b);
    }
}
