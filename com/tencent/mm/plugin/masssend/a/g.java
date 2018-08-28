package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends c<lw> {
    public g() {
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (au.HX()) {
            h.bcp();
            au.HU();
            if (bi.bH(bi.a((Long) com.tencent.mm.model.c.DT().get(102409, null), 0)) > 900000) {
                h.bcp().bck();
                h.bcp();
                c.dV(bi.VF());
            } else {
                x.d("MicroMsg.PostTaskMassSendListener", "time limit");
            }
        } else {
            x.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
        }
        return false;
    }
}
