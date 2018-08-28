package com.tencent.mm.plugin.fts;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class c$2 implements Runnable {
    final /* synthetic */ c joV;

    c$2(c cVar) {
        this.joV = cVar;
    }

    public final void run() {
        Looper.prepare();
        c.a(this.joV, new ag());
        Looper.loop();
    }
}
