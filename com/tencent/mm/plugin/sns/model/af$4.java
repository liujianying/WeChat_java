package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class af$4 implements Runnable {
    final /* synthetic */ af nqT;
    final /* synthetic */ int val$id;

    af$4(af afVar, int i) {
        this.nqT = afVar;
        this.val$id = i;
    }

    public final void run() {
        Looper.prepare();
        af.a(this.nqT)[this.val$id] = new ag();
        Looper.loop();
    }
}
