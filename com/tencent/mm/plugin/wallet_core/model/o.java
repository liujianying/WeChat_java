package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.by.c;
import com.tencent.mm.by.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class o implements ar {
    private static HashMap<Integer, d> cVM;
    private a kYj = new 7(this);
    private h<e> pqA = new h(new c<e>() {
        public final /* synthetic */ Object get() {
            g.Ek();
            return new e(g.Ei().dqq);
        }
    });
    private h<i> pqB = new h(new c<i>() {
        public final /* synthetic */ Object get() {
            g.Ek();
            return new i(g.Ei().dqq);
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.h> pqC = new h(new 2(this));
    private h<com.tencent.mm.plugin.wallet_core.d.g> pqD = new h(new 3(this));
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a pqE = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private com.tencent.mm.sdk.b.c pqF = new 4(this);
    private String pqG = "";
    private com.tencent.mm.sdk.b.c<sg> pqH = new 5(this);
    private com.tencent.mm.sdk.b.c<ti> pqI = new 6(this);
    private volatile q pqq = new q();
    private h<ag> pqr = new h(new 1(this));
    private volatile aa pqs = null;
    private h<ad> pqt = new h(new 12(this));
    private h<j> pqu = new h(new 18(this));
    private h<com.tencent.mm.plugin.wallet_core.d.c> pqv = new h(new 19(this));
    private h<com.tencent.mm.plugin.wallet_core.d.a> pqw = new h(new 20(this));
    private h<f> pqx = new h(new 21(this));
    private h<com.tencent.mm.plugin.wallet_core.d.d> pqy = new h(new c<com.tencent.mm.plugin.wallet_core.d.d>() {
        public final /* synthetic */ Object get() {
            g.Ek();
            return new com.tencent.mm.plugin.wallet_core.d.d(g.Ei().dqq);
        }
    });
    private u pqz = new u();

    static {
        k.b("tenpay_utils", o.class.getClassLoader());
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new 8());
        cVM.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new 9());
        cVM.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new 10());
        cVM.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new 11());
        cVM.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new 13());
        cVM.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new 14());
        cVM.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new 15());
        cVM.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new 16());
        cVM.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new 17());
    }

    public static o bOR() {
        return (o) p.v(o.class);
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public static j bOS() {
        if (g.Eg().Dx()) {
            return (j) bOR().pqu.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.g bOT() {
        if (g.Eg().Dx()) {
            return (com.tencent.mm.plugin.wallet_core.d.g) bOR().pqD.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.c bOU() {
        if (g.Eg().Dx()) {
            return (com.tencent.mm.plugin.wallet_core.d.c) bOR().pqv.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.h bOV() {
        if (g.Eg().Dx()) {
            return (com.tencent.mm.plugin.wallet_core.d.h) bOR().pqC.get();
        }
        throw new b();
    }

    public static ag bOW() {
        if (g.Eg().Dx()) {
            return (ag) bOR().pqr.get();
        }
        throw new b();
    }

    public static ad bOX() {
        if (g.Eg().Dx()) {
            return (ad) bOR().pqt.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.a bOY() {
        if (g.Eg().Dx()) {
            return (com.tencent.mm.plugin.wallet_core.d.a) bOR().pqw.get();
        }
        throw new b();
    }

    public static f bOZ() {
        if (g.Eg().Dx()) {
            return (f) bOR().pqx.get();
        }
        throw new b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.d bPa() {
        if (g.Eg().Dx()) {
            return (com.tencent.mm.plugin.wallet_core.d.d) bOR().pqy.get();
        }
        throw new b();
    }

    public static e bPb() {
        if (g.Eg().Dx()) {
            return (e) bOR().pqA.get();
        }
        throw new b();
    }

    public static i bPc() {
        if (g.Eg().Dx()) {
            return (i) bOR().pqB.get();
        }
        throw new b();
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public static aa bPd() {
        return bOR().pqs;
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
        com.tencent.mm.wallet_core.c.a.cCW();
        com.tencent.mm.wallet_core.c.a.init(ad.getContext());
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("paymsg", this.kYj, true);
        bOW().bPB();
        this.pqs = aa.bPg();
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("paymsg", this.pqs.hTD, true);
        com.tencent.mm.sdk.b.a.sFg.b(this.pqF);
        com.tencent.mm.sdk.b.a.sFg.b(this.pqz);
        com.tencent.mm.sdk.b.a.sFg.a(this.pqI);
        com.tencent.mm.sdk.b.a.sFg.a(this.pqH);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[]{"//cleanpaycn"});
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("paymsg", this.kYj, true);
        bOW().aMk();
        ad bOX = bOX();
        bOX.prw = null;
        bOX.prv.clear();
        bOX.prv = new ArrayList();
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("paymsg", this.pqs.hTD, true);
        if (aa.iOD != null) {
            aa.iOD.clear();
        }
        this.pqs = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.pqF);
        com.tencent.mm.sdk.b.a.sFg.c(this.pqz);
        com.tencent.mm.sdk.b.a.sFg.c(this.pqI);
        com.tencent.mm.sdk.b.a.sFg.c(this.pqH);
    }

    public static void w(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (q.GT()) {
            intent.setFlags(536870912);
            x.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.bg.d.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
        } else if (q.GU()) {
            intent.setFlags(536870912);
            com.tencent.mm.bg.d.b(context, "mall", ".ui.MallIndexOSUI", intent);
        } else {
            x.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
            intent.setFlags(536870912);
            com.tencent.mm.bg.d.b(context, "mall", ".ui.MallIndexUI", intent);
            g.Ek();
            if (g.Ei().isSDCardAvailable()) {
                com.tencent.mm.ar.k kVar = new com.tencent.mm.ar.k(11);
                g.Ek();
                g.Eh().dpP.a(kVar, 0);
            }
        }
    }

    public static q bPe() {
        return bOR().pqq;
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar) {
        return bOR().pqE.a(mMActivity, eVar, 1008);
    }

    public static boolean b(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar) {
        return bOR().pqE.a(mMActivity, eVar, 1006);
    }
}
