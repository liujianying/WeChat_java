package com.tencent.mm.plugin.i;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    public final void execute(g gVar) {
        int zj = m.zj();
        if ((zj & 1024) != 0) {
            x.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", new Object[]{Integer.valueOf(zj >> 12)});
            k.b("wechatsight_v7a", getClass().getClassLoader());
            if ((zj >> 12) >= 4) {
                b.nbT = 3;
                b.nbV = 3;
                b.nbW = 544000;
                return;
            }
            b.nbT = 1;
            b.nbV = 1;
            b.nbW = 640000;
            return;
        }
        x.i("MicroMsg.SightInitTask", "load wechatsight");
        k.b("wechatsight", getClass().getClassLoader());
        b.nbT = 1;
        b.nbV = 1;
        b.nbW = 640000;
    }

    public final String name() {
        return "boot-sight-init";
    }
}
