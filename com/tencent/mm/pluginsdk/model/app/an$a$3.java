package com.tencent.mm.pluginsdk.model.app;

import android.os.SystemClock;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.sdk.platformtools.x;

class an$a$3 implements Runnable {
    final /* synthetic */ a qAK;

    an$a$3(a aVar) {
        this.qAK = aVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - a.k(this.qAK);
        x.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + a.f(this.qAK) + " timeWait:" + currentTimeMillis + " sending:" + a.h(this.qAK) + " recving:" + a.g(this.qAK));
        if (a.f(this.qAK)) {
            if (currentTimeMillis >= 180000) {
                x.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + a.f(this.qAK) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.h(this.qAK) + " recving:" + a.g(this.qAK));
            } else {
                return;
            }
        }
        a.l(this.qAK);
        a.b(this.qAK);
        a.m(this.qAK);
        a.a(this.qAK);
        this.qAK.bFn.dgA = SystemClock.elapsedRealtime();
        a.n(this.qAK).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
