package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class m$2 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ long emX;
    final /* synthetic */ m emY;

    m$2(m mVar, long j, int i, int i2) {
        this.emY = mVar;
        this.emX = j;
        this.bFq = i;
        this.bFr = i2;
    }

    public final void run() {
        m.SW();
        m.c(this.emY);
        m.a(this.emY, "");
        long j = 0;
        if (this.emX > 0 && m.d(this.emY).get(Long.valueOf(this.emX)) != null) {
            j = ((a) m.d(this.emY).get(Long.valueOf(this.emX))).Ad();
        }
        x.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[]{Long.valueOf(this.emX), Long.valueOf(j), Integer.valueOf(this.bFq), Integer.valueOf(this.bFr)});
        if (!(this.bFq == 0 && this.bFr == 0)) {
            m.j(this.emY);
        }
        x.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[]{Integer.valueOf(m.Sg()), Integer.valueOf(m.e(this.emY)), Boolean.valueOf(m.f(this.emY)), Boolean.valueOf(m.g(this.emY))});
        if (m.e(this.emY) > 0) {
            m.h(this.emY);
        } else if (!m.g(this.emY)) {
            x.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
            s Ta = o.Ta();
            List k = m.k(this.emY);
            if (!(k == null || k.isEmpty())) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('(');
                for (int i = 0; i < k.size() - 1; i++) {
                    stringBuilder.append((Long) k.get(i));
                    stringBuilder.append(',');
                }
                Long l = (Long) k.get(k.size() - 1);
                if (l != null) {
                    stringBuilder.append(l);
                }
                stringBuilder.append(')');
                x.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[]{"UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString()});
                Ta.dCZ.fV("videoinfo2", r0);
            }
            m.i(this.emY);
        }
        m.SX();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
