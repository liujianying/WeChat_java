package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class a$4 implements Runnable {
    final /* synthetic */ a a;

    a$4(a aVar) {
        this.a = aVar;
    }

    public void run() {
        while (a.b(this.a) != null && !a.b(this.a).isEmpty() && !a.c(this.a)) {
            this.a.c();
            b d = a.d(this.a);
            if (d == null) {
                break;
            } else if (d != null && a.e(this.a) != null) {
                a.e(this.a).b(d);
                while (!a.f(this.a).isEmpty()) {
                    b bVar = (b) a.f(this.a).getFirst();
                    if (bVar.g > d.h) {
                        break;
                    }
                    a.e(this.a).c(bVar);
                    a.f(this.a).removeFirst();
                }
            }
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick > a.g(this.a) + 200) {
            a.b(this.a, a.h(this.a) + this.a.d());
            a.i(this.a);
            long e = this.a.e();
            a.c(this.a, a.j(this.a) + e);
            a.k(this.a);
            if (a.l(this.a) > 0) {
                a.d(this.a, a.j(this.a) / a.l(this.a));
            }
            if (e > a.m(this.a)) {
                a.e(this.a, e);
            }
            a.a(this.a, timeTick);
        }
        if (a.n(this.a)) {
            a.o(this.a);
        }
    }
}
