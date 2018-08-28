package com.tencent.liteav.beauty;

class b$7 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    b$7(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    public void run() {
        b.a(this.b, this.a);
    }
}
