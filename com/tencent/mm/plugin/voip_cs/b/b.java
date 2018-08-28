package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b implements ar {
    private static b oWk = null;
    private a oWl = new a();
    private d oWm = new d();
    private c oWn = new c();
    private com.tencent.mm.plugin.voip_cs.a.a oWo = new com.tencent.mm.plugin.voip_cs.a.a();
    private c oWp = new 1(this);

    private static b bMu() {
        if (oWk == null) {
            oWk = new b();
            au.HN().a("plugin.voip_cs", oWk);
        }
        return oWk;
    }

    public static a bMv() {
        return bMu().oWl;
    }

    public static d bMw() {
        g.Eg().Ds();
        if (bMu().oWm == null) {
            bMu().oWm = new d();
        }
        return bMu().oWm;
    }

    public static c bMx() {
        return bMu().oWn;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        com.tencent.mm.sdk.b.a.sFg.b(this.oWo);
        com.tencent.mm.sdk.b.a.sFg.b(this.oWp);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.oWo);
        com.tencent.mm.sdk.b.a.sFg.c(this.oWp);
    }
}
