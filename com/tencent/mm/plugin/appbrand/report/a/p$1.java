package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class p$1 implements Runnable {
    final /* synthetic */ Object[] grR;
    final /* synthetic */ p gsG;

    p$1(p pVar, Object[] objArr) {
        this.gsG = pVar;
        this.grR = objArr;
    }

    public final void run() {
        try {
            String str = (String) this.grR[18];
            if (!bi.oW(str)) {
                int indexOf = str.indexOf(63);
                if (indexOf < 0) {
                    str = "";
                } else {
                    str = p.encode(str.substring(indexOf + 1, str.length()));
                }
                this.grR[18] = str;
            }
        } catch (Exception e) {
            this.grR[18] = "";
        }
        h.mEJ.h(14992, e.j(this.grR));
        KVCommCrossProcessReceiver.brP();
    }
}
