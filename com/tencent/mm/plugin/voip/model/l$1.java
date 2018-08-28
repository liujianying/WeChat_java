package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.e.b.c.a;

class l$1 implements a {
    final /* synthetic */ l oKN;

    l$1(l lVar) {
        this.oKN = lVar;
    }

    public final void s(byte[] bArr, int i) {
        synchronized (l.j(this.oKN)) {
            if (this.oKN.oKv == 2 && l.a(this.oKN) != null) {
                if (l.b(this.oKN) == 1) {
                    l.a(this.oKN, System.currentTimeMillis());
                    l.b(this.oKN, l.c(this.oKN));
                    l.d(this.oKN);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    l.a(this.oKN, (int) ((currentTimeMillis - l.e(this.oKN)) - ((long) (l.oKL * 20))));
                    l.a(this.oKN, currentTimeMillis);
                }
                if (l.f(this.oKN) <= 10) {
                    l.b(this.oKN, 92);
                }
                l.b(this.oKN, ((l.a(this.oKN).bJu() + 24) + (l.f(this.oKN) * 3)) / 4);
                if (l.g(this.oKN) == 1) {
                    l.c(this.oKN, l.a(this.oKN).bJr());
                    if (l.h(this.oKN) >= l.f(this.oKN)) {
                        l.c(this.oKN, l.h(this.oKN) - l.f(this.oKN));
                    }
                    l.b(this.oKN, l.h(this.oKN));
                    l.i(this.oKN);
                } else {
                    l.b(this.oKN, 0);
                }
                this.oKN.oHa.oJX.recordCallback(bArr, i, l.f(this.oKN));
                l.oKL++;
            }
        }
    }

    public final void aN(int i, int i2) {
    }
}
