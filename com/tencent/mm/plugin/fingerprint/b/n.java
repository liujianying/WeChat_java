package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rf$a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<rf> {
    public n() {
        this.sFo = rf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rf rfVar = (rf) bVar;
        if (!g.Eg().Dx()) {
            x.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (rfVar instanceof rf) {
            x.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean aNd = c.aNd();
            x.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is " + aNd);
            rf$a rf_a = new rf$a();
            rf_a.cbY = aNd;
            rfVar.cbX = rf_a;
            if (rfVar.bJX != null) {
                rfVar.bJX.run();
            }
            return true;
        }
        return false;
    }
}
