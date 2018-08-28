package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class o$2 implements a {
    final /* synthetic */ o kDV;

    o$2(o oVar) {
        this.kDV = oVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        x.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d)});
        if (this.kDV.kDR) {
            this.kDV.kDR = false;
            this.kDV.kDT = System.currentTimeMillis();
            long j = this.kDV.kDT - this.kDV.kDS;
            x.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[]{Long.valueOf(j)});
            h.mEJ.h(10997, new Object[]{"10", "", Integer.valueOf(0), Long.valueOf(j)});
        }
        if (!(this.kDV.kDI == null || this.kDV.kDI.stK == null)) {
            this.kDV.kDI.stK.rjj = (double) f2;
            this.kDV.kDI.stK.rji = (double) f;
        }
        return true;
    }
}
