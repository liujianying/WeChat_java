package com.tencent.mm.model.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class g implements ar {
    private c dDT = null;

    private static g IV() {
        return (g) p.v(g.class);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        c IW = IW();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            IW.iQ((String) com.tencent.mm.kernel.g.Ei().DT().get(328193, null));
            if (IW.IU()) {
                f.iS(IW.dDN.dDJ);
            }
        } catch (Exception e) {
            x.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[]{e.toString()});
        }
        x.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        c IW = IW();
        IW.dDO = null;
        IW.dDN = null;
    }

    public static c IW() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (IV().dDT == null) {
            IV().dDT = new c();
        }
        return IV().dDT;
    }
}
