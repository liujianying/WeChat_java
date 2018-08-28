package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.model.by.a;
import com.tencent.mm.sdk.platformtools.x;

class o$3 implements a {
    final /* synthetic */ o luP;

    o$3(o oVar) {
        this.luP = oVar;
    }

    public final boolean IS() {
        x.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (o.a(this.luP) != null) {
            o.a(this.luP).aWS();
            if (o.a(this.luP).ltt != null) {
                x.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[]{i.h(o.a(this.luP).ltt)});
            }
        }
        return true;
    }
}
