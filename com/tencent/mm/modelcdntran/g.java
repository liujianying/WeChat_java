package com.tencent.mm.modelcdntran;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ab.c;
import com.tencent.mm.ab.e;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class g implements ar {
    private b dPH = null;
    private c dPI = null;
    private c dPJ;
    private long dPK = 0;
    private ag dPL = new 2(this, Looper.getMainLooper());
    private e dPM = new 3(this);

    public static g NA() {
        return (g) p.v(g.class);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public static String NB() {
        com.tencent.mm.kernel.g.Eg().Ds();
        return com.tencent.mm.kernel.g.Ei().cachePath + "cdndnsinfo/";
    }

    public final void bo(boolean z) {
    }

    public static c NC() {
        return NA().dPJ;
    }

    public final void bn(boolean z) {
        onAccountRelease();
        com.tencent.mm.kernel.g.Eg().Ds();
        if (NA().dPI == null) {
            NA().dPI = new c();
            x.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[]{Integer.valueOf(NA().dPI.hashCode())});
        }
        File file = new File(NB());
        if (!file.exists()) {
            file.mkdir();
        }
        this.dPJ = new c() {
            public final void a(kg kgVar, kg kgVar2, kg kgVar3) {
                x.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + kgVar.toString() + " getCore().engine:" + g.NE());
                if (g.NE() != null) {
                    g.NE().a(kgVar, kgVar2, kgVar3, null, null, null);
                    com.tencent.mm.kernel.g.Em().H(new 1(this));
                }
            }
        };
        com.tencent.mm.kernel.g.DF().a(379, this.dPM);
    }

    public static c ND() {
        if (NA().dPI == null) {
            synchronized (g.class) {
                if (NA().dPI == null) {
                    NA().dPI = new c();
                }
            }
        }
        return NA().dPI;
    }

    public static b NE() {
        if (NA().dPH == null) {
            com.tencent.mm.kernel.g.Eg();
            if (a.Dw()) {
                NA().dPH = new b(com.tencent.mm.kernel.g.Ei().cachePath, ND());
            } else {
                x.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", new Object[]{aa.duN + com.tencent.mm.a.g.u(("mm" + new Random().nextLong()).getBytes()) + "/"});
                NA().dPH = new b(r0, ND());
            }
        }
        return NA().dPH;
    }

    public final void onAccountRelease() {
        this.dPJ = null;
        if (this.dPH != null) {
            b bVar = this.dPH;
            CdnLogic.setCallBack(null);
            bVar.dOJ = null;
            this.dPH = null;
        }
        if (this.dPI != null) {
            c cVar = this.dPI;
            if (com.tencent.mm.kernel.g.Eg().Dx()) {
                com.tencent.mm.kernel.g.Ei().DT().b(cVar);
            }
            cVar.dOR.removeCallbacksAndMessages(null);
            com.tencent.mm.kernel.g.Eh().b(cVar.dOT);
            com.tencent.mm.kernel.g.Eh().dpP.b(379, cVar);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.dOS);
            this.dPI = null;
        }
        this.dPK = 0;
        this.dPL.removeCallbacksAndMessages(null);
        com.tencent.mm.kernel.g.DF().b(379, this.dPM);
    }

    public final void NF() {
        hB(0);
    }

    public final void hB(int i) {
        this.dPK = 0;
        this.dPL.removeMessages(1);
        com.tencent.mm.kernel.g.DF().a(new e(i), 0);
    }
}
