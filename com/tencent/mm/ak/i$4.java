package com.tencent.mm.ak;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class i$4 implements Runnable {
    final /* synthetic */ i dVa;

    i$4(i iVar) {
        this.dVa = iVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - i.g(this.dVa);
        if (i.h(this.dVa)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.h(this.dVa) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.h(this.dVa));
            } else {
                return;
            }
        }
        i.i(this.dVa);
        i.j(this.dVa);
        this.dVa.bFn.dgA = SystemClock.elapsedRealtime();
        i.k(this.dVa).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
