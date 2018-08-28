package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<nd> {
    public j() {
        this.sFo = nd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nd ndVar = (nd) bVar;
        if (!g.Eg().Dx()) {
            x.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (ndVar instanceof nd) {
            x.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            a.aMW();
            if (a.aMX() != null) {
                a.aMW();
                a.aMX();
                c.aNe();
                x.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            return true;
        }
        return false;
    }
}
