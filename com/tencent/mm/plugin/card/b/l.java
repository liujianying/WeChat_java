package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.x;

public final class l implements e {
    public float cXm = -85.0f;
    public float cXn = -1000.0f;
    private long dlj = 0;

    public final void G(float f, float f2) {
        this.cXm = f;
        this.cXn = f2;
        this.dlj = System.currentTimeMillis() / 1000;
    }

    public final void p(String str, String str2, int i) {
        if ((System.currentTimeMillis() / 1000) - this.dlj > 1800) {
            this.cXm = -85.0f;
            this.cXn = -1000.0f;
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.cXm == -85.0f) {
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.cXn == -1000.0f) {
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        g.Eh().dpP.a(1253, this);
        g.Eh().dpP.a(new u(this.cXm, this.cXn, str, str2, i), 0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.Eh().dpP.b(1253, this);
    }
}
