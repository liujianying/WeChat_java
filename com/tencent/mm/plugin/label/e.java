package com.tencent.mm.plugin.label;

import com.tencent.mm.am.b;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ag;
import java.util.HashMap;

public class e implements ar {
    private static HashMap<Integer, d> cVM;
    private ag kAB;
    private d kAC = new d();

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return af.diD;
            }
        });
    }

    private static e aYI() {
        au.HN();
        e eVar = (e) bs.iK("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    eVar = new e();
                    au.HN().a("plugin.label", eVar);
                }
            }
        }
        return eVar;
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        b bVar = new b();
        a.kAD = bVar;
        b.dYB = bVar;
        com.tencent.mm.sdk.b.a.sFg.b(this.kAC);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        a.kAD = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.kAC);
    }

    public static ag aYJ() {
        g.Eg().Ds();
        if (aYI().kAB == null) {
            e aYI = aYI();
            au.HU();
            aYI.kAB = new ag(c.FO());
        }
        return aYI().kAB;
    }
}
