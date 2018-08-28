package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class an$a$2 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ a qAK;

    an$a$2(a aVar, l lVar, int i, int i2) {
        this.qAK = aVar;
        this.bFp = lVar;
        this.bFq = i;
        this.bFr = i2;
    }

    public final void run() {
        int i;
        long j;
        long j2 = 0;
        Object obj = null;
        a.wy();
        if (this.bFp.getType() == 222) {
            x.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + this.bFq + " errCode:" + this.bFr);
            i = 0;
            j = -1;
        } else if (this.bFp.getType() == 221) {
            a.a(this.qAK);
            j = ((ac) this.bFp).qAh;
            i = ((ac) this.bFp).retCode;
        } else if (this.bFp.getType() == 220) {
            long j3;
            a.b(this.qAK);
            long j4 = ((al) this.bFp).qAh;
            int i2 = ((al) this.bFp).retCode;
            al alVar = (al) this.bFp;
            String str = alVar.qAe == null ? null : alVar.qAe.field_mediaSvrId;
            alVar = (al) this.bFp;
            if (alVar.qAe == null) {
                j3 = 0;
            } else {
                j3 = alVar.qAe.field_msgInfoId;
            }
            String str2 = (String) a.c(this.qAK).remove(Long.valueOf(j3));
            if (!bi.oW(((al) this.bFp).dVk)) {
                obj = 1;
            }
            if (obj == null && !bi.oW(str)) {
                b bVar = new b();
                ao.asF().b(j4, bVar);
                if (bVar.sKx == j4) {
                    l.a(bVar.field_msgInfoId, str, null);
                    x.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                    a.v(bVar.field_msgInfoId, str2);
                }
            }
            i = i2;
            j = j4;
        } else {
            x.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + this.bFp.getType());
            a.wz();
            return;
        }
        if (!(j == -1 || this.qAK.bFf.get(Long.valueOf(j)) == null)) {
            j2 = ((g.a) this.qAK.bFf.get(Long.valueOf(j))).Ad();
            this.qAK.bFf.remove(Long.valueOf(j));
        }
        x.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + this.bFp.getType() + " errtype:" + this.bFq + " errCode:" + this.bFr + " retCode:" + i + " rowid:" + j + " time:" + j2);
        if (this.bFq != 0) {
            a.d(this.qAK);
        }
        x.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.bB() + " stop:" + a.e(this.qAK) + " running:" + a.f(this.qAK) + " recving:" + a.g(this.qAK) + " sending:" + a.h(this.qAK));
        if (a.e(this.qAK) > 0) {
            a.i(this.qAK);
        } else if (!(a.h(this.qAK) || a.g(this.qAK))) {
            a.j(this.qAK);
        }
        a.wz();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
