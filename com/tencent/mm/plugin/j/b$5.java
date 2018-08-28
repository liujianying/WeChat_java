package com.tencent.mm.plugin.j;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;

class b$5 implements Runnable {
    final /* synthetic */ b hsX;

    public b$5(b bVar) {
        this.hsX = bVar;
    }

    public final void run() {
        b.a(this.hsX, false);
        if (b.b(this.hsX) != null) {
            if (b.d(this.hsX) != null) {
                b.d(this.hsX);
                ah.M(b.b(this.hsX));
            }
            b.b(this.hsX).isStop = true;
            b.a(this.hsX, null);
            h.mEJ.a(664, 8, 1, false);
        }
    }
}
