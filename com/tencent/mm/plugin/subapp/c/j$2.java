package com.tencent.mm.plugin.subapp.c;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements Runnable {
    final /* synthetic */ j orE;

    j$2(j jVar) {
        this.orE = jVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - j.j(this.orE);
        x.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(this.orE) + " timeWait:" + currentTimeMillis + " sending:" + j.g(this.orE) + " recving:" + j.f(this.orE));
        if (j.e(this.orE)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(this.orE) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + j.g(this.orE) + " recving:" + j.f(this.orE));
            } else {
                return;
            }
        }
        j.k(this.orE);
        j.b(this.orE);
        j.a(this.orE, 3);
        j.a(this.orE);
        this.orE.bFn.dgA = SystemClock.elapsedRealtime();
        j.l(this.orE).J(10, 10);
    }
}
