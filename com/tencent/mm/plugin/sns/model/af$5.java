package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class af$5 implements Runnable {
    final /* synthetic */ af nqT;
    final /* synthetic */ int val$id = 0;

    af$5(af afVar) {
        this.nqT = afVar;
    }

    public final void run() {
        Looper.prepare();
        af.b(this.nqT)[this.val$id] = new ag();
        Looper.loop();
    }
}
