package com.tencent.mm.modelvideo;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.platformtools.x;

class x$a$2 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ a eoz;

    x$a$2(a aVar, l lVar, int i, int i2) {
        this.eoz = aVar;
        this.bFp = lVar;
        this.bFq = i;
        this.bFr = i2;
    }

    public final void run() {
        int i;
        String str;
        a.KF();
        String str2;
        if (this.bFp.getType() == 150) {
            a.b(this.eoz);
            str2 = ((d) this.bFp).fileName;
            x.eoq = str2;
            int i2 = ((d) this.bFp).retCode;
            a.c(this.eoz);
            i = i2;
            str = str2;
        } else if (this.bFp.getType() == 149) {
            a.d(this.eoz);
            a.e(this.eoz);
            if (this.bFp instanceof g) {
                str2 = ((g) this.bFp).fileName;
                i = ((g) this.bFp).retCode;
                str = str2;
            } else if (this.bFp instanceof h) {
                i = 0;
                str = ((h) this.bFp).fileName;
            } else {
                i = 0;
                str = null;
            }
        } else {
            x.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + this.bFp.getType());
            a.Ty();
            return;
        }
        long j = 0;
        if (!(str == null || this.eoz.bFf.get(str) == null)) {
            j = ((g.a) this.eoz.bFf.get(str)).Ad();
            this.eoz.bFf.remove(str);
        }
        x.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + this.bFp.getType() + " errtype:" + this.bFq + " errCode:" + this.bFr + " retCode:" + i + " file:" + str + " time:" + j);
        if (this.bFq == 3 && i != 0) {
            a.f(this.eoz);
        } else if (this.bFq != 0) {
            a.a(this.eoz, 0);
        }
        x.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.KD() + " stop:" + a.g(this.eoz) + " running:" + a.h(this.eoz) + " recving:" + a.i(this.eoz) + " sending:" + a.j(this.eoz));
        if (a.g(this.eoz) > 0) {
            a.a(this.eoz);
        } else if (!(a.j(this.eoz) || a.i(this.eoz))) {
            a.k(this.eoz);
        }
        a.Ty();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
