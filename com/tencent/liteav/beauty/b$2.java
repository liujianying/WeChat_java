package com.tencent.liteav.beauty;

class b$2 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    b$2(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    public void run() {
        if (this.a > 0) {
            a.a().c();
        }
        if (b.e(this.b) != null && this.a >= 0) {
            b.e(this.b).f(this.a);
        }
    }
}
