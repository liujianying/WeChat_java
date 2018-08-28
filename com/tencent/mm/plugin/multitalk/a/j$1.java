package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements Runnable {
    final /* synthetic */ j lui;

    public j$1(j jVar) {
        this.lui = jVar;
    }

    public final void run() {
        Looper.prepare();
        x.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
        this.lui.lug = new ag();
        Looper.loop();
    }
}
