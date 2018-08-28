package com.tencent.mm.model.c;

import android.annotation.SuppressLint;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.b.b;
import java.util.HashMap;
import java.util.Map;

public class c implements ar {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> cVM;
    private a dEA = new 1(this);
    private com.tencent.mm.sdk.b.c dEB = new 2(this);
    private j.a dEC = new 3(this);
    private b dED = null;
    private final com.tencent.mm.plugin.auth.a.a dEE = new 4(this);
    private com.tencent.mm.storage.d dEy;
    private com.tencent.mm.storage.b dEz;

    static /* synthetic */ void Jz() {
        com.tencent.mm.storage.c fJ = Jx().fJ("100229");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            int i = bi.getInt((String) ckq.get("UseSvrTime"), 0);
            ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("client_server_diff_time_enable", i).putInt("client_server_diff_time_interval", bi.getInt((String) ckq.get("MinDiffTime"), 0)).commit();
            x.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(r0)});
            return;
        }
        ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        x.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
    }

    private static synchronized c Jw() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) p.v(c.class);
        }
        return cVar;
    }

    public static com.tencent.mm.storage.d Jx() {
        g.Eg().Ds();
        if (Jw().dEy == null) {
            Jw().dEy = new com.tencent.mm.storage.d(g.Ei().dqq);
        }
        return Jw().dEy;
    }

    public static com.tencent.mm.storage.b Jy() {
        g.Eg().Ds();
        if (Jw().dEz == null) {
            Jw().dEz = new com.tencent.mm.storage.b(g.Ei().dqq);
        }
        return Jw().dEz;
    }

    public final void bn(boolean z) {
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("newabtest", this.dEA, true);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("newabtestinfo", this.dEA, true);
        com.tencent.mm.sdk.b.a.sFg.b(this.dEB);
        Jx().c(this.dEC);
        this.dED = ((com.tencent.mm.plugin.auth.a.b) g.n(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.dEE);
    }

    public final void onAccountRelease() {
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("newabtest", this.dEA, true);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("newabtestinfo", this.dEA, true);
        com.tencent.mm.sdk.b.a.sFg.c(this.dEB);
        Jx().d(this.dEC);
        if (this.dED != null) {
            this.dED.dead();
            this.dED = null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new 5());
        cVM.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new 6());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }
}
