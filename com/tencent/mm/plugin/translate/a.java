package com.tencent.mm.plugin.translate;

import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c$a;
import com.tencent.mm.plugin.translate.a.c.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements ar {
    ag handler = new ag(Looper.getMainLooper());
    c oEg = b.oEu;
    at oEh = new at(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private c$a oEi = new 1(this);
    private com.tencent.mm.sdk.b.c oEj = new com.tencent.mm.sdk.b.c<rt>() {
        {
            this.sFo = rt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rt rtVar = (rt) bVar;
            x.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            a.this.handler.post(new 1(this, rtVar));
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c oEk = new 3(this);

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        c cVar = this.oEg;
        c$a c_a = this.oEi;
        if (!(c_a == null || cVar.dlt.contains(c_a))) {
            cVar.dlt.add(c_a);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.oEj);
        com.tencent.mm.sdk.b.a.sFg.b(this.oEk);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.oEj);
        com.tencent.mm.sdk.b.a.sFg.c(this.oEk);
        c cVar = this.oEg;
        c$a c_a = this.oEi;
        if (c_a != null && cVar.dlt.contains(c_a)) {
            cVar.dlt.remove(c_a);
        }
        c cVar2 = this.oEg;
        if (cVar2.oEr != null) {
            for (e eVar : cVar2.oEr) {
                if (eVar != null) {
                    au.DF().b(631, eVar);
                    if (eVar.oEB != null) {
                        eVar.oED.SO();
                        au.DF().c(eVar.oEB);
                    }
                    eVar.bIS();
                    eVar.oEz = null;
                }
            }
        }
        cVar2.oEt.clear();
        cVar2.oEs.clear();
        cVar2.dlt.clear();
        cVar2.htY = 0;
    }
}
