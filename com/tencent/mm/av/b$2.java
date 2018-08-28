package com.tencent.mm.av;

import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b eel;

    b$2(b bVar) {
        this.eel = bVar;
    }

    public final void run() {
        x.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        a.sFg.c(b.f(this.eel));
        SwEngine.stopContinousLocationUpdate();
        SwEngine.onDestroy();
        if (b.g(this.eel) != null) {
            b.g(this.eel).finish();
            b.a(this.eel, null);
        }
        b.l(this.eel);
        b.m(this.eel);
        b.n(this.eel);
        b.a(this.eel, false);
    }
}
