package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.x;

class d$2 implements Runnable {
    final /* synthetic */ d iXP;

    d$2(d dVar) {
        this.iXP = dVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - d.f(this.iXP);
        if (d.g(this.iXP)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.g(this.iXP) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + d.g(this.iXP));
            } else {
                return;
            }
        }
        d.a(this.iXP);
        d.h(this.iXP);
        d.i(this.iXP);
        d.j(this.iXP).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
