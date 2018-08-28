package com.tencent.mm.plugin.card.model;

import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.plugin.card.ui.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class am implements ar {
    private static HashMap<Integer, d> cVM;
    private a hxA;
    private k hxB;
    private o hxC;
    private c hxD;
    private com.tencent.mm.plugin.card.b.k hxE = null;
    private e hxF = null;
    private l hxG = null;
    private com.tencent.mm.plugin.card.b.d hxH = null;
    private j hxI = null;
    private com.tencent.mm.plugin.card.b.c hxJ;
    private g hxK;
    private l hxL;
    private j hxM;
    private com.tencent.mm.sdk.b.c hxN = new n();
    private com.tencent.mm.sdk.b.c hxO = new com.tencent.mm.plugin.card.b.o();
    private com.tencent.mm.sdk.b.c hxP = new com.tencent.mm.plugin.card.b.a();
    private b hxQ = new b();
    private com.tencent.mm.sdk.b.c hxR = new 1(this);
    private com.tencent.mm.sdk.b.c hxS = new 4(this);
    private bv.a hxT = new 5(this);
    private bv.a hxU = new bv.a() {
        public final void a(com.tencent.mm.ab.d.a aVar) {
            String a = ab.a(aVar.dIN.rcl);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
            } else {
                am.this.mHandler.post(new 1(this, a, aVar));
            }
        }
    };
    private com.tencent.mm.plugin.card.b.b hxv;
    private c hxw;
    private al hxx;
    private h hxy;
    private m hxz;
    private ag mHandler = new ag(Looper.getMainLooper());

    public am() {
        File file = new File(m.hwK);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(m.hwL);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private static am getCore() {
        com.tencent.mm.plugin.card.a.a aVar = (com.tencent.mm.plugin.card.a.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.card.a.a.class);
        if (aVar != null) {
            return ((PluginCard) aVar).getCore();
        }
        return null;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return c.diD;
            }
        });
        cVM.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return al.diD;
            }
        });
        cVM.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new 9());
        cVM.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new 10());
        cVM.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return o.diD;
            }
        });
        cVM.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new 2());
        cVM.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new 3());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.sdk.b.a.sFg.b(this.hxR);
        com.tencent.mm.sdk.b.a.sFg.b(this.hxS);
        com.tencent.mm.sdk.b.a.sFg.b(this.hxN);
        com.tencent.mm.sdk.b.a.sFg.b(this.hxO);
        com.tencent.mm.sdk.b.a.sFg.b(this.hxP);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("carditemmsg", this.hxT, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("notifysharecard", this.hxU, true);
        this.hxE = null;
        if (this.hxF != null) {
            this.hxF.htT.clear();
            this.hxF = null;
        }
        if (this.hxz != null) {
            m mVar = this.hxz;
            synchronized (mVar.huO) {
                mVar.huO.clear();
            }
            synchronized (mVar.huP) {
                mVar.huP.clear();
            }
            com.tencent.mm.kernel.g.Eh().dpP.b(563, mVar);
            com.tencent.mm.modelgeo.c OB = com.tencent.mm.modelgeo.c.OB();
            if (OB != null) {
                OB.c(mVar);
            }
            if (mVar.huR != null) {
                com.tencent.mm.kernel.g.Eh().dpP.c(mVar.huR);
            }
            this.hxz = null;
        }
        if (this.hxv != null) {
            this.hxv.detach();
            this.hxv = null;
        }
        if (this.hxA != null) {
            a aVar = this.hxA;
            synchronized (aVar.dsN) {
                aVar.hty.clear();
                aVar.htz.clear();
            }
            if (aVar.hya != null) {
                com.tencent.mm.kernel.g.Eh().dpP.c(aVar.hya);
            }
            com.tencent.mm.kernel.g.Eh().dpP.b(903, aVar);
            this.hxA = null;
        }
        if (this.hxH != null) {
            this.hxH.release();
            com.tencent.mm.plugin.card.b.d dVar = this.hxH;
            dVar.htB.clear();
            dVar.htN.clear();
            dVar.htO.clear();
            dVar.htP.clear();
            dVar.htR = false;
            this.hxH = null;
        }
        if (this.hxI != null) {
            j jVar = this.hxI;
            com.tencent.mm.kernel.g.Eh().dpP.b(907, jVar);
            Iterator it = jVar.huA.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) jVar.huC.get(str);
                jVar.huC.remove(str);
                jVar.huB.removeCallbacks(runnable);
            }
            jVar.huz.clear();
            jVar.huA.clear();
            jVar.huC.clear();
            this.hxI = null;
        }
        if (this.hxJ != null) {
            this.hxJ.release();
            this.hxJ = null;
        }
        if (this.hxK != null) {
            this.hxK.release();
            this.hxK = null;
        }
        this.hxG = null;
        b.ano().registerActivityLifecycleCallbacks(this.hxQ);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        if (getCore().hxv != null) {
            getCore().hxv.detach();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.hxR);
        com.tencent.mm.sdk.b.a.sFg.c(this.hxS);
        com.tencent.mm.sdk.b.a.sFg.c(this.hxN);
        com.tencent.mm.sdk.b.a.sFg.c(this.hxO);
        com.tencent.mm.sdk.b.a.sFg.c(this.hxP);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("carditemmsg", this.hxT, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("notifysharecard", this.hxU, true);
        b.ano().unregisterActivityLifecycleCallbacks(this.hxQ);
    }

    public static com.tencent.mm.plugin.card.b.b axh() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxv == null) {
            getCore().hxv = new com.tencent.mm.plugin.card.b.b();
        }
        return getCore().hxv;
    }

    public static c axi() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxw == null) {
            getCore().hxw = new c(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxw;
    }

    public static al axj() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxx == null) {
            getCore().hxx = new al(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxx;
    }

    public static h axk() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxy == null) {
            getCore().hxy = new h(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxy;
    }

    public static m axl() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxz == null) {
            getCore().hxz = new m();
        }
        return getCore().hxz;
    }

    public static com.tencent.mm.plugin.card.b.k axm() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxE == null) {
            getCore().hxE = new com.tencent.mm.plugin.card.b.k();
        }
        return getCore().hxE;
    }

    public static e axn() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxF == null) {
            getCore().hxF = new e();
        }
        return getCore().hxF;
    }

    public static l axo() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxG == null) {
            getCore().hxG = new l();
        }
        return getCore().hxG;
    }

    public static a axp() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxA == null) {
            getCore().hxA = new a();
        }
        return getCore().hxA;
    }

    public static k axq() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxB == null) {
            getCore().hxB = new k(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxB;
    }

    public static o axr() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxC == null) {
            getCore().hxC = new o(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxC;
    }

    public static c axs() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxD == null) {
            getCore().hxD = new c();
        }
        return getCore().hxD;
    }

    public static com.tencent.mm.plugin.card.b.d axt() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxH == null) {
            getCore().hxH = new com.tencent.mm.plugin.card.b.d();
        }
        return getCore().hxH;
    }

    public static j axu() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxI == null) {
            getCore().hxI = new j();
        }
        return getCore().hxI;
    }

    public static com.tencent.mm.plugin.card.b.c axv() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxJ == null) {
            getCore().hxJ = new com.tencent.mm.plugin.card.b.c();
        }
        return getCore().hxJ;
    }

    public static l axw() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxL == null) {
            getCore().hxL = new l(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxL;
    }

    public static j axx() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxM == null) {
            getCore().hxM = new j(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return getCore().hxM;
    }

    public static g axy() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (getCore().hxK == null) {
            getCore().hxK = new g();
        }
        return getCore().hxK;
    }
}
