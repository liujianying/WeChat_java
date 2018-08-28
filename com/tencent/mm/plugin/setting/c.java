package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import java.util.HashMap;

public final class c implements ar {
    private a mOA = new 2(this);
    private n mOB = new 3(this);
    private a mOC = new 4(this);
    private n mOD = new 5(this);
    private b mOz = new b() {
        public final void a(int i, m mVar, Object obj) {
            if (i == 2) {
                String str = (String) obj;
                ab Yb = ((i) g.l(i.class)).FR().Yb(str);
                if (Yb != null && !com.tencent.mm.l.a.gd(Yb.field_type) && Yb.By() && !Yb.Bz()) {
                    g.Em().h(new 1(this, str), 5000);
                }
            }
        }
    };

    public c() {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("redpointinfo", this.mOA, true);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("crowdtest", this.mOC, true);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.mOB);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.mOD);
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sWY, Integer.valueOf(com.tencent.mm.protocal.d.qVN))).intValue();
        long longValue = ((Long) g.Ei().DT().get(aa.a.sWZ, Long.valueOf(0))).longValue();
        if (intValue <= com.tencent.mm.protocal.d.qVN || longValue < System.currentTimeMillis()) {
            btp();
        }
        if (z) {
            g.Ei().DT().set(34, Integer.valueOf((q.GQ() & -1048577) & -4194305));
            bay bay = new bay();
            bay.raB = 1048576;
            bay.sdm = 0;
            ((i) g.l(i.class)).FQ().b(new h.a(39, bay));
            bay = new bay();
            bay.raB = 4194304;
            bay.sdm = 0;
            ((i) g.l(i.class)).FQ().b(new h.a(39, bay));
            x.i("MicroMsg.SubCoreSetting", "set void default open");
        }
        if (com.tencent.mm.k.g.AT().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1 && (q.GJ() & 32) == 0) {
            ((i) g.l(i.class)).FR().a(this.mOz);
        }
    }

    public final void bo(boolean z) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("redpointinfo", this.mOA, true);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("crowdtest", this.mOC, true);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.mOB);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.mOD);
        ((i) g.l(i.class)).FR().b(this.mOz);
    }

    static void btp() {
        g.Ei().DT().a(aa.a.sWZ, Long.valueOf(0));
        g.Ei().DT().a(aa.a.sXa, "");
        com.tencent.mm.s.c.Cp().v(262157, false);
    }
}
