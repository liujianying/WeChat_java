package com.tencent.mm.model;

import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

class f$2 implements Runnable {
    final /* synthetic */ Map dAA;
    final /* synthetic */ f dAz;

    f$2(f fVar, Map map) {
        this.dAz = fVar;
        this.dAA = map;
    }

    public final void run() {
        int i = bi.getInt((String) this.dAA.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
        if (bi.getInt((String) this.dAA.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0) {
            d.mOw.a(i, false, false, false);
        } else {
            d.mOw.a(i, true, true, true);
        }
    }
}
