package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements a {
    final /* synthetic */ a kIc;

    a$3(a aVar) {
        this.kIc = aVar;
    }

    public final void b(Addr addr) {
        x.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[]{addr.toString()});
        this.kIc.kHN = addr;
        String str = addr.dRJ;
        String Oy = addr.Oy();
        this.kIc.kHQ.bWB = this.kIc.activity.getResources().getString(h.location_conversation);
        if (addr.tag != null && addr.tag.equals(this.kIc.kHQ.kCv)) {
            this.kIc.kHQ.kCz = Oy;
        } else if (!bi.oW(addr.dRH)) {
            this.kIc.kHR.kIe.setVisibility(0);
        }
        if (addr.tag != null && this.kIc.kHT.containsKey(addr.tag)) {
            c cVar = (c) this.kIc.kHT.get(addr.tag);
            cVar.setText(cVar.getPreText() + Oy);
        }
        float f = addr.dRT;
        f = addr.dRS;
    }
}
