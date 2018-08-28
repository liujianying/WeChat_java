package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.e;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ar$10 extends c<e> {
    final /* synthetic */ ar nrO;

    ar$10(ar arVar) {
        this.nrO = arVar;
        this.sFo = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e eVar = (e) bVar;
        if (eVar.bGf.className.equals("SnsTimeLineUI")) {
            this.nrO.emL = eVar.bGf.ahg;
            x.d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[]{Boolean.valueOf(this.nrO.emL)});
            if (this.nrO.emL || this.nrO.emK) {
                this.nrO.byS();
            }
            i Tc = o.Tc();
            Tc.emL = this.nrO.emL;
            if (Tc.emL) {
                Tc.stopDownload();
            }
        }
        return false;
    }
}
