package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class c$2 extends TimerTask {
    final /* synthetic */ c iOX;

    c$2(c cVar) {
        this.iOX = cVar;
    }

    public final void run() {
        synchronized (c.b(this.iOX)) {
            if (!c.c(this.iOX)) {
                x.w(c.ew(), "hy: already stopped");
                cancel();
            }
            ah.A(new 1(this));
        }
    }
}
