package com.tencent.mm.plugin.location.model;

import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.e;
import com.tencent.mm.model.p;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.HashSet;

public class l implements ar {
    private a kDA = new 6(this);
    private c kDh = new c();
    private a kDi = new a((byte) 0);
    private b kDj = new b((byte) 0);
    private a$a kDk;
    private int kDl = 0;
    private e kDm = new b();
    private e kDn = new n();
    private o kDo = null;
    private p kDp = null;
    private i kDq = null;
    private m kDr = null;
    private d kDs = new d();
    private k kDt = null;
    private j kDu = null;
    private com.tencent.mm.ab.e kDv = new com.tencent.mm.ab.e() {
        public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
            if (i == 0 && i2 == 0) {
                v vVar = (v) lVar;
                bin Ru = vVar.Ru();
                if (Ru.hcE == 0) {
                    l.l(vVar.bJC, v.mY(Ru.rjF));
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c kDw = new 2(this);
    private com.tencent.mm.sdk.b.c kDx = new 3(this);
    private com.tencent.mm.sdk.b.c kDy = new 4(this);
    private com.tencent.mm.sdk.b.c kDz = new 5(this);

    private static final class c extends com.tencent.mm.sdk.b.c<iy> {
        private volatile boolean Hg;

        private c() {
            this.Hg = false;
            this.sFo = iy.class.getName().hashCode();
        }

        /* synthetic */ c(byte b) {
            this();
            this.sFo = iy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iy iyVar = (iy) bVar;
            if (!(iyVar instanceof iy)) {
                return false;
            }
            x.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + iyVar.bSB.bSv);
            switch (iyVar.bSB.bSv) {
                case 0:
                    l.aZf().kCD = new HashSet();
                    this.Hg = true;
                    return true;
                case 1:
                    if (this.Hg) {
                        String[] Q = l.aZf().Q(iyVar.bSB.bGS);
                        iyVar.bSC.bPu = Q[0];
                        iyVar.bSC.bSE = Q[1];
                        return true;
                    }
                    iyVar.bSC.bPu = "err_not_started";
                    return true;
                case 2:
                    if (!this.Hg) {
                        return true;
                    }
                    l.aZf().aZa();
                    return true;
                default:
                    return true;
            }
        }
    }

    private static l aZe() {
        return (l) p.v(l.class);
    }

    public static a$a aZf() {
        g.Eg().Ds();
        if (aZe().kDk == null) {
            aZe().kDk = new a$a();
        }
        return aZe().kDk;
    }

    public static k aZg() {
        g.Eg().Ds();
        if (aZe().kDt == null) {
            aZe().kDt = new k();
        }
        return aZe().kDt;
    }

    public static j aZh() {
        g.Eg().Ds();
        if (aZe().kDu == null) {
            aZe().kDu = new j();
        }
        return aZe().kDu;
    }

    public static o aZi() {
        if (aZe().kDo == null) {
            aZe().kDo = new o();
        }
        return aZe().kDo;
    }

    public static p aZj() {
        if (aZe().kDp == null) {
            aZe().kDp = new p();
        }
        return aZe().kDp;
    }

    public static i aZk() {
        if (aZe().kDq == null) {
            aZe().kDq = new i();
        }
        return aZe().kDq;
    }

    public static m aZl() {
        if (aZe().kDr == null) {
            aZe().kDr = new m();
        }
        return aZe().kDr;
    }

    public static void R(bd bdVar) {
        if (bdVar != null && bdVar.field_msgId != 0) {
            bd.b YW = bd.b.YW(bdVar.field_content);
            g.DF().a(new v((float) YW.kCx, (float) YW.kCw, bdVar.field_msgId), 0);
        }
    }

    public static String aZm() {
        return g.Ei().cachePath + "trackroom/";
    }

    public final HashMap<Integer, h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(48), this.kDm);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(61), this.kDn);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("trackmsg", this.kDA, true);
        g.DF().a(424, this.kDv);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDh);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDi);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDw);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDx);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDy);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDz);
        com.tencent.mm.sdk.b.a.sFg.b(this.kDj);
        com.tencent.mm.ay.d.eli = aZi();
        com.tencent.mm.ay.d.elh = aZj();
        com.tencent.mm.bl.a.a.a.sCg = aZl();
        g.Eg().Ds();
        if (aZe().kDs == null) {
            aZe().kDs = new d();
        }
        com.tencent.mm.plugin.r.c.a.kKA = aZe().kDs;
    }

    public final void onAccountRelease() {
        if (this.kDo != null) {
            this.kDo.kDP = null;
            this.kDo.stop();
            this.kDo.rP(1);
        }
        com.tencent.mm.ab.d.c.b(Integer.valueOf(48), this.kDm);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(61), this.kDn);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("trackmsg", this.kDA, true);
        g.DF().b(424, this.kDv);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDh);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDi);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDw);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDx);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDy);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDz);
        com.tencent.mm.sdk.b.a.sFg.c(this.kDj);
        if (this.kDq != null) {
            i iVar = this.kDq;
            iVar.aZd();
            iVar.gCt.clear();
        }
        if (this.kDt != null) {
            this.kDt.stop();
        }
        if (this.kDu != null) {
            aZg().a(this.kDu);
        }
    }

    public final void bo(boolean z) {
    }

    public static void l(long j, String str) {
        bd dW = ((i) g.l(i.class)).bcY().dW(j);
        if (dW.aQo()) {
            dW.er(str);
            ((i) g.l(i.class)).bcY().a(j, dW);
        }
    }
}
