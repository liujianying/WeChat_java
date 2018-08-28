package com.tencent.mm.booter;

import com.tencent.mm.model.ad;
import com.tencent.mm.model.ae;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class a implements ad {
    private static volatile a cWx;
    private ar cWv = new ar();
    private com.tencent.mm.sdk.platformtools.ar.a cWw = new 1(this);
    private List<ae> cWy = new ArrayList();
    private c cWz;

    private a() {
        this.cWv.a(this.cWw);
        this.cWv.fN(com.tencent.mm.sdk.platformtools.ad.getContext());
        if (this.cWz == null) {
            this.cWz = new 2(this);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.cWz);
    }

    public static a xt() {
        if (cWx == null) {
            synchronized (a.class) {
                if (cWx == null) {
                    cWx = new a();
                }
            }
        }
        return cWx;
    }

    public final void a(ae aeVar) {
        if (aeVar != null) {
            x.d("MicroMsg.BackgroundPlayer", "add callback : %s", aeVar.toString());
            this.cWy.add(aeVar);
        }
    }

    public final void b(ae aeVar) {
        if (aeVar != null) {
            this.cWy.remove(aeVar);
        }
    }

    public final void xu() {
        if (this.cWy != null) {
            for (ae HB : this.cWy) {
                HB.HB();
            }
        }
    }

    public final void xv() {
        if (this.cWy != null) {
            for (ae HC : this.cWy) {
                HC.HC();
            }
        }
    }
}
