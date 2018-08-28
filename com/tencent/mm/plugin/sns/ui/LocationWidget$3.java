package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class LocationWidget$3 implements a {
    final /* synthetic */ LocationWidget nOH;

    LocationWidget$3(LocationWidget locationWidget) {
        this.nOH = locationWidget;
    }

    public final void b(Addr addr) {
        x.i("MicroMsg.LocationWidget", "get info %s", new Object[]{addr.toString()});
        if (LocationWidget.e(this.nOH)) {
            LocationWidget.f(this.nOH);
            if (bi.oW(LocationWidget.g(this.nOH))) {
                LocationWidget.a(this.nOH, addr.dRJ);
                LocationWidget.f(this.nOH);
            }
        }
    }
}
