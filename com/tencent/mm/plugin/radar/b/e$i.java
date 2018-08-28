package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.radar.b.e.b;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.x;

final class e$i implements a {
    final /* synthetic */ e mkD;

    e$i(e eVar) {
        this.mkD = eVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        b bVar;
        if (e.a(this.mkD)) {
            bVar = e.mkl;
            x.d(e.access$getTAG$cp(), "cancel location");
            return false;
        } else if (e.c(this.mkD) != null) {
            return false;
        } else {
            if (z) {
                o.a(2006, f, f2, (int) d2);
                bVar = e.mkl;
                x.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
                e.a(this.mkD, new Location(f2, f, (int) d2, i, "", ""));
                e.e(this.mkD).fZ(0);
            } else {
                e.f(this.mkD);
            }
            e.c(this.mkD);
            e.bpv();
            return false;
        }
    }
}
