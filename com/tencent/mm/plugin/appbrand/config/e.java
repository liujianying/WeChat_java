package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.a.g;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;

public final class e extends c<bc> {
    public e() {
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB.bIC == 38) {
            int i = bcVar.bIB.bID;
            int i2 = bcVar.bIB.bIE;
            String str = bcVar.bIB.filePath;
            if (!bi.oW(str) || com.tencent.mm.a.e.cn(str)) {
                boolean z;
                String adX = AppBrandGlobalSystemConfig.adX();
                if (com.tencent.mm.a.e.cn(adX)) {
                    String cu = g.cu(str);
                    z = (bi.oW(cu) || cu.equals(g.cu(adX))) ? false : true;
                } else {
                    z = true;
                }
                if (z) {
                    AppBrandGlobalSystemConfig.adW();
                    j.fN(str, adX);
                    com.tencent.mm.pluginsdk.g.a.a.b.c.ccr().ae(38, i, i2);
                }
            }
        }
        return true;
    }
}
