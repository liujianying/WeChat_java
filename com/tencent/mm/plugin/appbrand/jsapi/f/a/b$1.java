package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.r.b.b;
import com.tencent.mm.plugin.appbrand.r.b.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class b$1 implements b {
    b$1() {
    }

    public final void a(double d, double d2, a aVar, double d3, double d4, double d5) {
        x.d("MicroMsg.AppBrandMapManager", "refresh location latitude = %f, longitude = %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
        if (b.yT()) {
            synchronized (b.AW()) {
                for (HashMap values : b.AW().values()) {
                    for (c cVar : values.values()) {
                        if (!(cVar == null || !cVar.fSX || cVar.isBackground)) {
                            ah.A(new c$8(cVar, d, d2, aVar, d3));
                        }
                    }
                }
            }
            return;
        }
        x.w("MicroMsg.AppBrandMapManager", "refresh location fail, no perrmission");
    }
}
