package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import java.util.HashMap;
import java.util.HashSet;

public class b implements ar {
    private static HashMap<Integer, d> cVM;
    private a dEC = new 3(this);
    private bv.a iwx = new 4(this);
    private ab mtM = null;
    public com.tencent.mm.plugin.remittance.b.b mtN = null;
    private com.tencent.mm.plugin.remittance.b.d mtO = null;
    private c<mp> mtP = new 5(this);
    private c<tj> mtQ = new 6(this);

    static {
        com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new 1());
        cVM.put(Integer.valueOf("RemittanceRecord".hashCode()), new 2());
    }

    public static b bqQ() {
        return (b) p.v(b.class);
    }

    public static com.tencent.mm.plugin.remittance.b.b bqR() {
        if (bqQ().mtN == null) {
            b bqQ = bqQ();
            g.Ek();
            bqQ.mtN = new com.tencent.mm.plugin.remittance.b.b(g.Ei().dqq);
        }
        return bqQ().mtN;
    }

    public static com.tencent.mm.plugin.remittance.b.d bqS() {
        if (bqQ().mtO == null) {
            b bqQ = bqQ();
            g.Ek();
            bqQ.mtO = new com.tencent.mm.plugin.remittance.b.d(g.Ei().dqq);
        }
        return bqQ().mtO;
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        if (this.mtM != null) {
            ab abVar = this.mtM;
            synchronized (abVar.lock) {
                abVar.myE = new HashSet();
                abVar.myF.clear();
            }
        }
        com.tencent.mm.model.c.c.Jx().c(this.dEC);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("paymsg", this.iwx, true);
        com.tencent.mm.sdk.b.a.sFg.a(this.mtP);
        com.tencent.mm.sdk.b.a.sFg.a(this.mtQ);
    }

    public final void onAccountRelease() {
        com.tencent.mm.model.c.c.Jx().d(this.dEC);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("paymsg", this.iwx, true);
        com.tencent.mm.sdk.b.a.sFg.c(this.mtP);
        com.tencent.mm.sdk.b.a.sFg.c(this.mtQ);
    }

    public final ab bqT() {
        if (this.mtM == null) {
            this.mtM = new ab();
        }
        return this.mtM;
    }
}
