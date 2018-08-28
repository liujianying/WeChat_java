package com.tencent.mm.plugin.clean.c.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class b$1 implements Runnable {
    final /* synthetic */ b hRv;

    b$1(b bVar) {
        this.hRv = bVar;
    }

    public final void run() {
        Looper.prepare();
        this.hRv.hRt.put(Long.valueOf(Thread.currentThread().getId()), new ag(Looper.myLooper()));
        Looper.loop();
    }
}
