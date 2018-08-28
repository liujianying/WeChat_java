package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.wear.model.f.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class e {
    c cYt = new 11(this);
    al eOf = new al(Looper.getMainLooper(), new 7(this), true);
    a iJe = new 2(this);
    c kRJ = new 3(this);
    c ocR = new c<ke>() {
        {
            this.sFo = ke.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ke keVar = (ke) bVar;
            if (e.a(e.this) && !"gh_3dfda90e39d6".equals(keVar.bUz.talker)) {
                au.HU();
                bd GE = com.tencent.mm.model.c.FT().GE(keVar.bUz.talker);
                boolean z = GE != null ? g.AT().getInt("WearLuckyBlock", 0) == 0 && (GE.cmb() || GE.cmc()) : false;
                if (z) {
                    a.bSl().pIS.a(new com.tencent.mm.plugin.wear.model.f.g(GE));
                    if (keVar.bUz.bGz > 1) {
                        e.m(keVar.bUz.talker, keVar.bUz.bGz, false);
                    }
                } else {
                    e.m(keVar.bUz.talker, keVar.bUz.bGz, true);
                }
            }
            return false;
        }
    };
    private PowerManager pJg;
    private KeyguardManager pJh;
    c pJi = new 4(this);
    c pJj = new 5(this);
    c pJk = new 6(this);
    c pJl = new 8(this);
    c pJm = new 9(this);
    c pJn = new 10(this);

    static /* synthetic */ boolean a(e eVar) {
        return eVar.pJh.inKeyguardRestrictedInputMode() || !eVar.pJg.isScreenOn();
    }

    public e() {
        x.i("MicroMsg.Wear.WearLogic", "Create!");
        this.ocR.cht();
        this.pJi.cht();
        this.pJj.cht();
        this.pJk.cht();
        this.pJl.cht();
        this.pJm.cht();
        this.pJn.cht();
        this.cYt.cht();
        this.kRJ.cht();
        this.eOf.J(1800000, 1800000);
        this.pJg = (PowerManager) ad.getContext().getSystemService("power");
        this.pJh = (KeyguardManager) ad.getContext().getSystemService("keyguard");
        au.HU();
        com.tencent.mm.model.c.FT().a(this.iJe, null);
    }

    public static void m(String str, int i, boolean z) {
        a.bSl().pIS.a(new j(str, i, z));
    }
}
