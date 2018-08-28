package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.x;

class PickPoi$1 implements a {
    final /* synthetic */ PickPoi kJn;

    PickPoi$1(PickPoi pickPoi) {
        this.kJn = pickPoi;
    }

    public final void b(Addr addr) {
        x.d("MicroMsg.PickPoi", "onGetAddrss  %s", new Object[]{addr.toString()});
        if (PickPoi.a(this.kJn) == null) {
            x.i("MicroMsg.PickPoi", "error, empty poi!");
            return;
        }
        f a = PickPoi.a(this.kJn);
        a.kJE = addr;
        a.kJu = addr.dRH;
        a.bhC = (double) addr.dRS;
        a.bhD = (double) addr.dRT;
        a.kJy = addr.dRI;
        a.kJz = addr.dRJ;
        a.kJB = addr.dRN;
        a.kJD = addr.dRP;
        a.kJG = addr.dRR;
        x.d("poidata", "roughAddr %s", new Object[]{addr.toString()});
        if (PickPoi.b(this.kJn) != null) {
            PickPoi.b(this.kJn).notifyDataSetChanged();
        }
    }
}
