package com.tencent.mm.e.b;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements Runnable {
    final /* synthetic */ i bFs;

    i$2(i iVar) {
        this.bFs = iVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - i.j(this.bFs);
        x.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(this.bFs) + " timeWait:" + currentTimeMillis + " sending:" + i.g(this.bFs) + " recving:" + i.f(this.bFs));
        if (i.e(this.bFs)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(this.bFs) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.g(this.bFs) + " recving:" + i.f(this.bFs));
            } else {
                return;
            }
        }
        i.k(this.bFs);
        i.b(this.bFs);
        i.a(this.bFs, 3);
        i.a(this.bFs);
        this.bFs.bFn.dgA = SystemClock.elapsedRealtime();
        i.l(this.bFs).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
