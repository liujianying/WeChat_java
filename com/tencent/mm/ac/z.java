package com.tencent.mm.ac;

import com.tencent.mm.ab.d.c;
import com.tencent.mm.ac.a.b;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.i;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.ac.m.a;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.util.HashMap;

public class z implements ar {
    private static HashMap<Integer, d> cVM;
    private static long dMF = 0;
    private e dBE = new e();
    private e dMG;
    private a dMH = null;
    private k dMI = null;
    private i dMJ;
    private h dMK = null;
    private com.tencent.mm.ac.a.d dML = null;
    private b dMM = null;
    private k dMN = null;
    private g dMO = null;
    private i dMP = null;
    private h dMQ = null;
    private c dMR = null;
    private r dMS = null;
    private t dMT = null;
    private a dMU;
    private bv.a dMV = new 9(this);
    private az.a dMW = new 10(this);
    private e.a dMX = new 2(this);

    static /* synthetic */ void h(d dVar) {
        if (dVar.LZ() && !dVar.Ma() && dVar.bG(false) != null && dVar.bG(false).MB() != null && !bi.oW(dVar.Mg())) {
            if (((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(dVar.Mg()) == null) {
                x.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(dVar.field_username) == null) {
                x.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", new Object[]{dVar.field_username});
                ai aiVar = new ai(dVar.field_username);
                if (!dVar.Ma()) {
                    x.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[]{dVar.Mg(), dVar.field_username});
                    aiVar.ef(bi.oV(dVar.Mg()));
                    aiVar.clx();
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().d(aiVar);
                }
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new 3());
        cVM.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new 4());
        cVM.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new 5());
        cVM.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new 6());
        cVM.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new 7());
        cVM.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new 8());
    }

    private static synchronized z MW() {
        z zVar;
        synchronized (z.class) {
            zVar = (z) p.v(z.class);
        }
        return zVar;
    }

    public static i MX() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMJ == null) {
            MW().dMJ = new i(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMJ;
    }

    public static e MY() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMG == null) {
            MW().dMG = new e(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMG;
    }

    public static h MZ() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMK == null) {
            MW().dMK = new h();
            h hVar = MW().dMK;
            com.tencent.mm.kernel.g.Eh().dpP.a(675, hVar);
            com.tencent.mm.kernel.g.Eh().dpP.a(672, hVar);
            com.tencent.mm.kernel.g.Eh().dpP.a(674, hVar);
            synchronized (hVar.dMd) {
                hVar.dMf.clear();
            }
        }
        return MW().dMK;
    }

    public static com.tencent.mm.ac.a.d Na() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dML == null) {
            MW().dML = new com.tencent.mm.ac.a.d(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dML;
    }

    public static b Nb() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMM == null) {
            MW().dMM = new b(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMM;
    }

    public static k Nc() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMN == null) {
            MW().dMN = new k(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMN;
    }

    public static g Nd() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMO == null) {
            MW().dMO = new g(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMO;
    }

    public static r Ne() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMS == null) {
            MW().dMS = new r(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMS;
    }

    public static t Nf() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMT == null) {
            MW().dMT = new t(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMT;
    }

    public static h Ng() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMQ == null) {
            MW().dMQ = new h();
        }
        return MW().dMQ;
    }

    public static c Nh() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMR == null) {
            MW().dMR = new c(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return MW().dMR;
    }

    public static a Ni() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMH == null) {
            MW().dMH = new a();
        }
        return MW().dMH;
    }

    public static k Nj() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMI == null) {
            MW().dMI = new k();
        }
        return MW().dMI;
    }

    public static a Nk() {
        if (MW().dMU == null) {
            MW().dMU = new a();
        }
        return MW().dMU;
    }

    public static i Nl() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (MW().dMP == null) {
            MW().dMP = new i();
        }
        return MW().dMP;
    }

    public static long Nm() {
        if (dMF == 0) {
            Object obj = com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sPA, null);
            if (obj != null && (obj instanceof Long)) {
                dMF = ((Long) obj).longValue();
                x.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[]{Long.valueOf(dMF)});
            }
        }
        if (dMF == 0) {
            dMF = System.currentTimeMillis();
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sPA, Long.valueOf(dMF));
            x.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[]{Long.valueOf(dMF)});
        }
        return dMF;
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        c.a(Integer.valueOf(55), this.dBE);
        c.a(Integer.valueOf(57), this.dBE);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().b(this.dMW);
        MY().a(this.dMX, null);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.dMV, true);
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(55), this.dBE);
        c.b(Integer.valueOf(57), this.dBE);
        if (MW().dMK != null) {
            h hVar = MW().dMK;
            com.tencent.mm.kernel.g.Eh().dpP.b(675, hVar);
            com.tencent.mm.kernel.g.Eh().dpP.b(672, hVar);
            com.tencent.mm.kernel.g.Eh().dpP.b(674, hVar);
            synchronized (hVar.dMd) {
                hVar.dMf.clear();
            }
            hVar.dMe.clear();
        }
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().c(this.dMW);
            MY().a(this.dMX);
        }
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.dMV, true);
    }

    public final void bo(boolean z) {
    }
}
