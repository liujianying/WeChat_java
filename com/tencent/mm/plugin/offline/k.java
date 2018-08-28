package com.tencent.mm.plugin.offline;

import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vending.b.b;
import java.util.HashMap;
import java.util.Map;

public class k implements ar {
    private static HashMap<Integer, d> cVM = new HashMap();
    private static Map<String, String> dmW = new HashMap();
    public static boolean lJx = false;
    public static int lJy = 10;
    private b feT;
    private a hTD = new 4(this);
    private m lJA;
    private s lJr = null;
    private e lJs = null;
    private i lJt = null;
    private com.tencent.mm.plugin.offline.b.a lJu = null;
    private com.tencent.mm.plugin.offline.ui.d lJv = new com.tencent.mm.plugin.offline.ui.d();
    public f lJw = new f();
    private c<tc> lJz = new c<tc>() {
        {
            this.sFo = tc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            tc tcVar = (tc) bVar;
            if (!bi.oW(tcVar.ceC.ceD)) {
                com.tencent.mm.plugin.offline.c.a.Ja(tcVar.ceC.ceD);
            }
            return false;
        }
    };
    private ag mHandler = new ag(Looper.getMainLooper());

    static {
        com.tencent.mm.wallet_core.a.i("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.i("OfflineBindCardProcess", c.class);
        cVM.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new d() {
            public final String[] xb() {
                return com.tencent.mm.plugin.offline.b.a.diD;
            }
        });
    }

    public static k bkO() {
        return (k) p.v(k.class);
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        this.feT = ((com.tencent.mm.plugin.auth.a.b) g.n(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new 3(this));
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("paymsg", this.hTD, true);
        com.tencent.mm.sdk.b.a.sFg.b(this.lJv);
        com.tencent.mm.sdk.b.a.sFg.b(this.lJz);
        this.lJr = null;
        this.lJs = null;
        this.lJt = null;
        this.lJA = new m();
    }

    public final void onAccountRelease() {
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("paymsg", this.hTD, true);
        com.tencent.mm.sdk.b.a.sFg.c(this.lJv);
        com.tencent.mm.sdk.b.a.sFg.c(this.lJz);
        if (this.lJA != null) {
            m mVar = this.lJA;
            bkO();
            bkP().b(mVar);
            com.tencent.mm.sdk.b.a.sFg.c(mVar.kRJ);
        }
        this.lJA = null;
        this.feT.dead();
    }

    public static s bkP() {
        g.Eg().Ds();
        if (bkO().lJr == null) {
            bkO().lJr = new s();
        }
        return bkO().lJr;
    }

    public static e bkQ() {
        g.Eg().Ds();
        if (bkO().lJs == null) {
            bkO().lJs = new e();
        }
        return bkO().lJs;
    }

    public static i bkR() {
        g.Eg().Ds();
        if (bkO().lJt == null) {
            bkO().lJt = new i();
        }
        return bkO().lJt;
    }

    public static void aw(int i, String str) {
        if (str != null) {
            g.Ek();
            g.Ei().DT().set(i, str);
            g.Ek();
            g.Ei().DT().lm(true);
        }
    }

    public static String uk(int i) {
        g.Ek();
        return (String) g.Ei().DT().get(i, null);
    }

    public static com.tencent.mm.plugin.offline.b.a bkS() {
        if (g.Eg().Dx()) {
            if (bkO().lJu == null) {
                k bkO = bkO();
                g.Ek();
                bkO.lJu = new com.tencent.mm.plugin.offline.b.a(g.Ei().dqq);
            }
            return bkO().lJu;
        }
        throw new com.tencent.mm.model.b();
    }
}
