package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class g implements ar {
    private static HashMap<Integer, d> eOr;
    private e eOq;
    private c eOs = new 2(this);
    private c eOt = new c<hp>() {
        {
            this.sFo = hp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hp hpVar = (hp) bVar;
            hpVar.bQW.bQX = f.cn(hpVar.bQV.context);
            return false;
        }
    };
    private c eOu = new 4(this);

    private static synchronized g Yp() {
        g gVar;
        synchronized (g.class) {
            gVar = (g) p.v(g.class);
        }
        return gVar;
    }

    public static e Yq() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (Yp().eOq == null) {
            Yp().eOq = new e(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return Yp().eOq;
    }

    static {
        HashMap hashMap = new HashMap();
        eOr = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        return eOr;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        a.sFg.b(this.eOs);
        a.sFg.b(this.eOt);
        a.sFg.b(this.eOu);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        a.sFg.c(this.eOs);
        a.sFg.c(this.eOt);
        a.sFg.c(this.eOu);
    }
}
