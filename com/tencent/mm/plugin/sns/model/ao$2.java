package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ao$2 extends c<e> {
    final /* synthetic */ ao nrB;

    ao$2(ao aoVar) {
        this.nrB = aoVar;
        this.sFo = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e eVar = (e) bVar;
        if (eVar.bGf.className.equals("SnsTimeLineUI")) {
            this.nrB.emL = eVar.bGf.ahg;
            x.i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", new Object[]{Boolean.valueOf(this.nrB.emL)});
        }
        return false;
    }
}
