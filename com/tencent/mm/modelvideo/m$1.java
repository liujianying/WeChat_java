package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements Runnable {
    final /* synthetic */ long emX;
    final /* synthetic */ m emY;

    m$1(m mVar, long j) {
        this.emY = mVar;
        this.emX = j;
    }

    public final void run() {
        long j = 0;
        m.SW();
        m.c(this.emY);
        m.a(this.emY, "");
        if (this.emX > 0 && m.d(this.emY).get(Long.valueOf(this.emX)) != null) {
            j = ((a) m.d(this.emY).get(Long.valueOf(this.emX))).Ad();
        }
        x.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.emX + " time:" + j + " inCnt:" + m.Sg() + " stop:" + m.e(this.emY) + " running:" + m.f(this.emY) + " sending:" + m.g(this.emY));
        if (m.e(this.emY) > 0) {
            m.h(this.emY);
        } else if (!m.g(this.emY)) {
            m.i(this.emY);
        }
        m.SX();
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
