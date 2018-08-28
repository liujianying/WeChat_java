package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.f.b;

class a$5 implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    a$5(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public void run() {
        if (this.a.b == 6) {
            a.f(this.b).add(this.a);
            return;
        }
        a.b(this.b).add(this.a);
        a.f(this.b, (long) a.b(this.b).size());
        if (a.e(this.b) != null) {
            a.f(this.b, a.p(this.b) + ((long) a.e(this.b).o()));
        }
        a.g(this.b, this.a.h);
    }
}
