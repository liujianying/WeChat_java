package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.fg;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<fg> {
    public c() {
        this.sFo = fg.class.getName().hashCode();
    }

    private boolean a(fg fgVar) {
        if (fgVar instanceof fg) {
            a bye = af.bye();
            bye.a(fgVar.bNs.type, fgVar.bNs.username, new 1(this, fgVar));
            bye.a(1, fgVar.bNs.username, fgVar.bNs.bNu, fgVar.bNs.bNv);
            return true;
        }
        x.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        return false;
    }
}
