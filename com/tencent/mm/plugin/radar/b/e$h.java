package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.b.e.b;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

final class e$h implements a {
    final /* synthetic */ e mkD;

    e$h(e eVar) {
        this.mkD = eVar;
    }

    public final boolean vD() {
        b bVar;
        if (e.a(this.mkD)) {
            bVar = e.mkl;
            x.d(e.access$getTAG$cp(), "cancel radar searching");
        } else {
            e.a(this.mkD, e$f.RadarSearching);
            bVar = e.mkl;
            x.d(e.access$getTAG$cp(), "status: %s", new Object[]{e.b(this.mkD)});
            Location c = e.c(this.mkD);
            if (c == null) {
                bVar = e.mkl;
                x.e(e.access$getTAG$cp(), "error! location is null!");
            } else if (c.ccc()) {
                bVar = e.mkl;
                x.e(e.access$getTAG$cp(), "error! location is null!");
            } else {
                bVar = e.mkl;
                x.d(e.access$getTAG$cp(), "do once search");
                e eVar = this.mkD;
                float f = c.dRS;
                float f2 = c.dRT;
                int i = c.accuracy;
                int i2 = c.bUi;
                String str = c.mac;
                e.h(str, "it.mac");
                String str2 = c.bUk;
                e.h(str2, "it.cellId");
                e.a(eVar, new b(1, f, f2, i, i2, str, str2));
                g.DF().d((l) e.d(this.mkD));
            }
        }
        return false;
    }
}
