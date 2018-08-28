package com.tencent.liteav.videoencoder;

class a$4 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ a b;

    a$4(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    public void run() {
        a.b(this.b, this.a);
    }
}
