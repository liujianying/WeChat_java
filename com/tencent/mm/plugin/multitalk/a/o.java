package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.by.a;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class o implements ar {
    private static HashMap<Integer, d> cVM;
    private a jpz = new 3(this);
    private c luG;
    private e luH;
    private l luI;
    private h luJ;
    private a luK;
    private g luL;
    private com.tencent.mm.plugin.multitalk.b.a luM;
    private c luN;
    private f luO;

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    private static o bgI() {
        au.HN();
        o oVar = (o) bs.iK("plugin.multitalk");
        if (oVar != null) {
            return oVar;
        }
        Object oVar2 = new o();
        au.HN().a("plugin.multitalk", oVar2);
        return oVar2;
    }

    public static com.tencent.mm.plugin.multitalk.b.a bgJ() {
        au.HU();
        if (com.tencent.mm.model.c.Df() == 0) {
            throw new b();
        }
        if (bgI().luM == null) {
            o bgI = bgI();
            au.HU();
            bgI.luM = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.model.c.FO());
        }
        return bgI().luM;
    }

    public static c bgK() {
        au.HU();
        if (com.tencent.mm.model.c.Df() == 0) {
            throw new b();
        }
        if (bgI().luN == null) {
            o bgI = bgI();
            au.HU();
            bgI.luN = new c(com.tencent.mm.model.c.FO());
        }
        return bgI().luN;
    }

    public static h bgL() {
        g.Eg().Ds();
        if (bgI().luJ == null) {
            bgI().luJ = new h();
        }
        return bgI().luJ;
    }

    public static c bgM() {
        g.Eg().Ds();
        if (bgI().luG == null) {
            bgI().luG = new c();
        }
        return bgI().luG;
    }

    public static e bgN() {
        g.Eg().Ds();
        if (bgI().luH == null) {
            bgI().luH = new e();
        }
        return bgI().luH;
    }

    public static l bgO() {
        g.Eg().Ds();
        if (bgI().luI == null) {
            bgI().luI = new l();
        }
        return bgI().luI;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        this.luG = new c();
        this.luK = new a(this);
        au.getSysCmdMsgExtension().a("multivoip", this.luK, true);
        au.El().a(this.jpz);
        com.tencent.mm.pluginsdk.o.a.qyi = bgP();
        bgP().bgB();
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.luG != null) {
            e eVar = this.luG;
            au.DF().b(1918, eVar);
            au.DF().b(1919, eVar);
            au.DF().b(1927, eVar);
            au.DF().b(1928, eVar);
            au.DF().b(1929, eVar);
            au.DF().b(1931, eVar);
            au.DF().b(1932, eVar);
            au.DF().b(1933, eVar);
            au.DF().b(1935, eVar);
            au.DF().b(1937, eVar);
            au.DF().b(1938, eVar);
            au.DF().b(1939, eVar);
            this.luG = null;
        }
        if (this.luH != null) {
            e eVar2 = this.luH;
            ad.getContext().unregisterReceiver(eVar2.ltJ);
            com.tencent.mm.sdk.b.a.sFg.c(eVar2.ltK);
            eVar2.g(false, false, false);
            this.luH = null;
        }
        if (this.luI != null) {
            this.luI.bgH();
            this.luI = null;
        }
        if (this.luJ != null) {
            this.luJ.reset();
            this.luJ = null;
        }
        au.getSysCmdMsgExtension().b("multivoip", this.luK, true);
        au.El().b(this.jpz);
    }

    public static g bgP() {
        if (bgI().luL == null) {
            bgI().luL = new g();
        }
        return bgI().luL;
    }

    public static f bgQ() {
        if (bgI().luO == null) {
            bgI().luO = new f();
        }
        return bgI().luO;
    }
}
