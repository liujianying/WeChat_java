package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.sdk.platformtools.x;

class a$4 implements Runnable {
    final /* synthetic */ a iXG;

    a$4(a aVar) {
        this.iXG = aVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - this.iXG.bFk;
        if (this.iXG.bFi) {
            if (currentTimeMillis >= 300000) {
                x.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.iXG.bFi + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.iXG.bFi);
            } else {
                return;
            }
        }
        x.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[]{Long.valueOf(currentTimeMillis)});
        this.iXG.bFh = false;
        this.iXG.bFi = true;
        this.iXG.iXD = 0;
        this.iXG.bFj = 3;
        this.iXG.bFo.J(100, 100);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
