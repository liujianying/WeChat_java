package com.tencent.mm.plugin.j;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;

class b$8 implements Runnable {
    final /* synthetic */ b hsX;

    b$8(b bVar) {
        this.hsX = bVar;
    }

    public final void run() {
        if (b.f(this.hsX) != null) {
            if (b.d(this.hsX) != null) {
                b.d(this.hsX);
                ah.M(b.f(this.hsX));
            }
            b.f(this.hsX).isStop = true;
            b.b(this.hsX, null);
            h.mEJ.a(664, 2, 1, false);
        }
        if (b.h(this.hsX) != null) {
            b.h(this.hsX).isStop = true;
        }
    }
}
