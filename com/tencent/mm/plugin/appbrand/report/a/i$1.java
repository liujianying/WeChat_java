package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class i$1 implements Runnable {
    final /* synthetic */ Object[] grR;
    final /* synthetic */ i grS;

    i$1(i iVar, Object[] objArr) {
        this.grS = iVar;
        this.grR = objArr;
    }

    public final void run() {
        try {
            String str = (String) this.grR[19];
            if (!bi.oW(str)) {
                int indexOf = str.indexOf(63);
                if (indexOf < 0) {
                    str = "";
                } else {
                    str = p.encode(str.substring(indexOf + 1, str.length()));
                }
                this.grR[19] = str;
            }
        } catch (Exception e) {
            this.grR[19] = "";
        }
        h.mEJ.h(13536, e.j(this.grR));
        KVCommCrossProcessReceiver.brP();
    }
}
