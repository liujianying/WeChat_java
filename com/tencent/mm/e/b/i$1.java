package com.tencent.mm.e.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ i bFs;

    i$1(i iVar, l lVar, int i, int i2) {
        this.bFs = iVar;
        this.bFp = lVar;
        this.bFq = i;
        this.bFr = i2;
    }

    public final void run() {
        int i;
        String str;
        i.wy();
        String str2;
        if (this.bFp.getType() == 128) {
            i.a(this.bFs);
            str2 = ((e) this.bFp).fileName;
            i = ((e) this.bFp).retCode;
            str = str2;
        } else if (this.bFp.getType() == 127) {
            i.b(this.bFs);
            str2 = ((f) this.bFp).fileName;
            i = ((f) this.bFp).retCode;
            str = str2;
        } else {
            x.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + this.bFp.getType());
            i.wz();
            return;
        }
        long j = 0;
        if (!(str == null || this.bFs.bFf.get(str) == null)) {
            j = ((a) this.bFs.bFf.get(str)).Ad();
            this.bFs.bFf.remove(str);
        }
        x.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + this.bFp.getType() + " errtype:" + this.bFq + " errCode:" + this.bFr + " retCode:" + i + " file:" + str + " time:" + j);
        if (this.bFq == 3 && i != 0) {
            i.c(this.bFs);
        } else if (this.bFq != 0) {
            i.a(this.bFs, 0);
        }
        x.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.bB() + " stop:" + i.d(this.bFs) + " running:" + i.e(this.bFs) + " recving:" + i.f(this.bFs) + " sending:" + i.g(this.bFs));
        if (i.d(this.bFs) > 0) {
            i.h(this.bFs);
        } else if (!(i.g(this.bFs) || i.f(this.bFs))) {
            i.i(this.bFs);
            x.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[]{Integer.valueOf(this.bFq), Integer.valueOf(i), Boolean.valueOf(i.bFm)});
            if (i.bFm && this.bFq == 4) {
                g.Em().h(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                        i$1.this.bFs.run();
                    }
                }, 10000);
            }
        }
        i.wz();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
