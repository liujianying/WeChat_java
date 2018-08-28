package com.tencent.mm.plugin.j;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.j.b.3;
import com.tencent.mm.storage.aa.a;

class b$3$1 implements Runnable {
    final /* synthetic */ 3 hsZ;

    b$3$1(3 3) {
        this.hsZ = 3;
    }

    public final void run() {
        g.Ei().DT().a(a.sYj, Long.valueOf(-1));
        g.Ei().DT().a(a.sYi, Long.valueOf(0));
        g.Ei().DT().lm(true);
        b.avr().avs().delete();
        b.d(this.hsZ.hsX, false);
    }
}
