package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sdk.platformtools.bi;

class g$4 implements Runnable {
    final /* synthetic */ g mny;

    g$4(g gVar) {
        this.mny = gVar;
    }

    public final void run() {
        if (g.Eg().Dx()) {
            bi.g(c.Gb(), "ReaderApp_", 604800000);
        }
    }

    public final String toString() {
        return super.toString() + "|onAccountPostReset";
    }
}
