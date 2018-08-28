package com.tencent.mm.ai;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class d implements ar {
    private static HashMap<Integer, com.tencent.mm.bt.h.d> cVM;
    private b dTb;
    private c dTc;

    private static d OJ() {
        au.HN();
        a aVar = (a) bs.iK("plugin.subapp");
        d dVar = aVar == null ? null : (d) aVar.Oi(d.class.getName());
        if (dVar != null) {
            return dVar;
        }
        dVar = new d();
        aVar.b(d.class.getName(), dVar);
        return dVar;
    }

    public static b OK() {
        g.Eg().Ds();
        if (OJ().dTb == null) {
            d OJ = OJ();
            au.HU();
            OJ.dTb = new b(c.FO());
        }
        return OJ().dTb;
    }

    public final void onAccountRelease() {
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        if (this.dTc == null) {
            this.dTc = new c();
        }
        am.a.dBr = this.dTc;
        x.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[]{this.dTc});
        g.a(f.class, new com.tencent.mm.pluginsdk.ui.applet.c());
        g.a(h.class, new com.tencent.mm.pluginsdk.ui.applet.h());
    }

    public final void bo(boolean z) {
    }
}
