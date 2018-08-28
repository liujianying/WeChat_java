package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class e$10 implements a {
    final /* synthetic */ e ltL;

    e$10(e eVar) {
        this.ltL = eVar;
    }

    public final boolean vD() {
        x.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (this.ltL.ltF == null) {
            this.ltL.ltG = 0;
            this.ltL.ltH.SO();
            return false;
        } else if (e.dE(ad.getContext())) {
            this.ltL.b(this.ltL.ltF);
            this.ltL.ltF = null;
            this.ltL.ltG = 0;
            this.ltL.ltH.SO();
            h.mEJ.a(500, 7, 1, false);
            return false;
        } else if (System.currentTimeMillis() - this.ltL.ltG < 60000) {
            return true;
        } else {
            this.ltL.ltF = null;
            this.ltL.ltG = 0;
            this.ltL.ltH.SO();
            return false;
        }
    }
}
