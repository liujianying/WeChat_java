package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.g.a.pd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class c$a extends c<pd> {
    public c$a() {
        this.sFo = pd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pd pdVar = (pd) bVar;
        if (pdVar instanceof pd) {
            if (!(pdVar.bZY == null || bi.oW(pdVar.bZY.bYo) || pdVar.bZY.bZZ == null)) {
                l lVar = new l(pdVar.bZY.bYo, pdVar.bZY.bZZ);
                g.Ek();
                g.DF().a(lVar, 0);
            }
            return true;
        }
        x.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
        return false;
    }
}
