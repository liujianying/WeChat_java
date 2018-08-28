package com.tencent.liteav.beauty;

class b$4 implements Runnable {
    final /* synthetic */ b a;

    b$4(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (b.h(this.a) != null) {
            a.a().d();
        }
        if (b.h(this.a) == null) {
            if (b.a(this.a) != null) {
                b.a(this.a).d();
                b.a(this.a, null);
            }
        } else if (b.a(this.a) == null) {
            b.a(this.a, b.f(this.a), b.g(this.a), b.h(this.a));
        } else {
            b.a(this.a).a(b.h(this.a));
        }
    }
}
