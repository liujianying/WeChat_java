package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class af$6 implements Runnable {
    final /* synthetic */ af nqT;

    af$6(af afVar) {
        this.nqT = afVar;
    }

    public final void run() {
        Looper.prepare();
        af.a(this.nqT, new ag());
        Looper.loop();
    }
}
