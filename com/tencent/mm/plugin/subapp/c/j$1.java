package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ j orE;

    j$1(j jVar, l lVar, int i, int i2) {
        this.orE = jVar;
        this.bFp = lVar;
        this.bFq = i;
        this.bFr = i2;
    }

    public final void run() {
        int i;
        String str;
        j.wy();
        String str2;
        if (this.bFp.getType() == 128) {
            j.a(this.orE);
            str2 = ((e) this.bFp).fileName;
            i = ((e) this.bFp).retCode;
            str = str2;
        } else if (this.bFp.getType() == 329) {
            j.b(this.orE);
            str2 = ((b) this.bFp).fileName;
            i = ((b) this.bFp).retCode;
            str = str2;
        } else {
            x.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + this.bFp.getType());
            j.wz();
            return;
        }
        long j = 0;
        if (!(str == null || this.orE.bFf.get(str) == null)) {
            j = ((a) this.orE.bFf.get(str)).Ad();
            this.orE.bFf.remove(str);
        }
        x.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + this.bFp.getType() + " errtype:" + this.bFq + " errCode:" + this.bFr + " retCode:" + i + " file:" + str + " time:" + j);
        if (this.bFq == 3 && i != 0) {
            j.c(this.orE);
        } else if (this.bFq != 0) {
            j.a(this.orE, 0);
        }
        x.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.bB() + " stop:" + j.d(this.orE) + " running:" + j.e(this.orE) + " recving:" + j.f(this.orE) + " sending:" + j.g(this.orE));
        if (j.d(this.orE) > 0) {
            j.h(this.orE);
        } else if (!(j.g(this.orE) || j.f(this.orE))) {
            j.i(this.orE);
        }
        j.wz();
    }
}
