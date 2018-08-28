package com.tencent.mm.plugin.hce.a;

import com.tencent.mm.g.a.ic;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<ic> {
    public a() {
        this.sFo = ic.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ic icVar = (ic) bVar;
        if (!b.aVW()) {
            icVar.bRD.errCode = 13000;
            icVar.bRD.Yy = "not support NFC";
        } else if (b.aVV()) {
            icVar.bRD.errCode = 0;
            icVar.bRD.Yy = "support HCE and system NFC switch is opened";
        } else {
            icVar.bRD.errCode = 13002;
            icVar.bRD.Yy = "not support HCE";
        }
        return false;
    }
}
