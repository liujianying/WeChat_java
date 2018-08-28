package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class h$2 implements a {
    final /* synthetic */ h lax;

    h$2(h hVar) {
        this.lax = hVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        x.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:" + a);
        h.bcp().Gj(a);
        h.bcp().bck();
        h.bcp();
        c.dV(bi.VF());
    }
}
