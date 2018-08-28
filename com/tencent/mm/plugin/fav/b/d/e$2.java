package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.x;

class e$2 implements Runnable {
    final /* synthetic */ e iXR;

    e$2(e eVar) {
        this.iXR = eVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - e.f(this.iXR);
        if (e.g(this.iXR)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.g(this.iXR) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + e.g(this.iXR));
            } else {
                return;
            }
        }
        e.a(this.iXR);
        e.h(this.iXR);
        e.i(this.iXR);
        e.j(this.iXR).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
