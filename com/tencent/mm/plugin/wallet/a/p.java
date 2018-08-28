package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import java.io.File;
import java.util.HashMap;

public class p implements ar {
    private int cdM = 0;
    private int peA = 0;
    private o peB = new o();
    private v peC = new v();
    private i peD = new i();
    private b peE = new b() {
        public final void a(int i, m mVar, Object obj) {
            int intValue;
            if (bi.p(obj, 0) == 339975) {
                g.Ek();
                intValue = ((Integer) g.Ei().DT().get(339975, Integer.valueOf(0))).intValue();
                if (intValue != p.this.peA) {
                    ap.ccb().reset();
                    p.this.peA = intValue;
                }
            } else if (a.sTs.equals(obj)) {
                g.Ek();
                intValue = ((Integer) g.Ei().DT().get(a.sTs, Integer.valueOf(0))).intValue();
                if (intValue != p.this.cdM) {
                    ap.ccb().reset();
                    p.this.cdM = intValue;
                }
            }
        }
    };
    private n peF = new 2(this);
    private j peG = new j();

    static {
        com.tencent.mm.wallet_core.a.i("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        com.tencent.mm.wallet_core.a.i("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    }

    public p() {
        File file = new File(com.tencent.mm.plugin.wallet_core.d.b.bPR());
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static p bNp() {
        return (p) com.tencent.mm.model.p.v(p.class);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        g.Ek();
        this.peA = ((Integer) g.Ei().DT().get(339975, Integer.valueOf(0))).intValue();
        g.Ek();
        this.cdM = ((Integer) g.Ei().DT().get(a.sTs, Integer.valueOf(0))).intValue();
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("paymsg", this.peF);
        com.tencent.mm.sdk.b.a.sFg.b(this.peB);
        com.tencent.mm.sdk.b.a.sFg.b(this.peC);
        com.tencent.mm.sdk.b.a.sFg.b(this.peD);
        this.peG.cht();
        g.Ek();
        g.Ei().DT().a(this.peE);
        g.Ek();
        g.Ei().DT().a(a.sZH, Boolean.valueOf(false));
    }

    public final void onAccountRelease() {
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("paymsg", this.peF);
        com.tencent.mm.sdk.b.a.sFg.c(this.peB);
        com.tencent.mm.sdk.b.a.sFg.c(this.peC);
        com.tencent.mm.sdk.b.a.sFg.c(this.peD);
        this.peG.dead();
        g.Ek();
        g.Ei().DT().b(this.peE);
    }

    public static ag bNq() {
        return com.tencent.mm.plugin.wallet_core.model.o.bOW();
    }

    public static String Ol() {
        g.Ek();
        String str = (String) g.Ei().DT().get(6, null);
        String Fp = com.tencent.mm.sdk.platformtools.ap.Fp(str);
        if (bi.oW(str)) {
            return "";
        }
        return str.substring(Fp.length() + 1);
    }

    public static String bNr() {
        g.Ek();
        String str = (String) g.Ei().DT().get(6, null);
        if (bi.oW(str)) {
            str = "";
        } else {
            str = com.tencent.mm.sdk.platformtools.ap.Fp(str.replace("+", ""));
        }
        if (!bi.oW(str)) {
            return str;
        }
        if (q.GS()) {
            return "27";
        }
        return "86";
    }
}
