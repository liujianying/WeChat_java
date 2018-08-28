package com.tencent.mm.plugin.j;

import com.tencent.mm.plugin.j.c.c.a;

class b$6 implements a {
    final /* synthetic */ b hsX;

    b$6(b bVar) {
        this.hsX = bVar;
    }

    public final void finish() {
        b.a(this.hsX, new Runnable() {
            public final void run() {
                b.a(b$6.this.hsX, null);
                b$6.this.hsX.dN(false);
            }
        });
    }
}
