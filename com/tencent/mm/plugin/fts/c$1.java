package com.tencent.mm.plugin.fts;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class c$1 implements Runnable {
    final /* synthetic */ c joV;
    final /* synthetic */ int val$id;

    c$1(c cVar, int i) {
        this.joV = cVar;
        this.val$id = i;
    }

    public final void run() {
        Looper.prepare();
        c.a(this.joV)[this.val$id] = new ag();
        Looper.loop();
    }
}
