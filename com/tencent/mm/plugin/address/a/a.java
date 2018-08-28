package com.tencent.mm.plugin.address.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements ar {
    private com.tencent.mm.plugin.address.b.a.a eXA = null;
    private j eXB = new j();
    private k eXC = new k();
    private l eXz = null;

    public static a Zv() {
        au.HN();
        a aVar = (a) bs.iK("plugin.address");
        if (aVar != null) {
            return aVar;
        }
        x.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
        aVar = new a();
        au.HN().a("plugin.address", aVar);
        return aVar;
    }

    public static com.tencent.mm.plugin.address.b.a.a Zw() {
        g.Eg().Ds();
        if (Zv().eXA == null) {
            Zv().eXA = new com.tencent.mm.plugin.address.b.a.a();
        }
        return Zv().eXA;
    }

    public static l Zx() {
        g.Eg().Ds();
        if (Zv().eXz == null) {
            Zv().eXz = new l();
        }
        return Zv().eXz;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.sdk.b.a.sFg.b(this.eXB);
        com.tencent.mm.sdk.b.a.sFg.b(this.eXC);
        l Zx = Zx();
        au.HU();
        Zx.path = c.Gq() + "addrmgr";
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.eXB);
        com.tencent.mm.sdk.b.a.sFg.c(this.eXC);
    }
}
