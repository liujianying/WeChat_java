package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class a implements ar {
    private n jgf = new n();
    private i jgg = new i();
    private j jgh = new j();
    private b jgi = new b();
    private f jgj = new f();
    private g jgk = new g();
    private c jgl;

    static {
        com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    }

    public static a aMW() {
        return (a) p.v(a.class);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreFingerPrint", "alvinluo SoterWrapperApi isInit: %b in SubCoreFingerprint initTA", new Object[]{Boolean.valueOf(com.tencent.d.b.b.a.cFO().isInit())});
        if (com.tencent.d.b.b.a.cFO().isInit()) {
            aMY();
        } else {
            x.i("MicroMsg.SubCoreFingerPrint", "alvinluo soter is not initialized, do init");
            com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.plugin.fingerprint.b.d());
            com.tencent.mm.kernel.g.Em().h(new 1(this), 1500);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.jgf);
        com.tencent.mm.sdk.b.a.sFg.b(this.jgg);
        com.tencent.mm.sdk.b.a.sFg.b(this.jgh);
        com.tencent.mm.sdk.b.a.sFg.b(this.jgi);
        com.tencent.mm.sdk.b.a.sFg.b(this.jgj);
        com.tencent.mm.sdk.b.a.sFg.b(this.jgk);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.jgf);
        this.jgg.release();
        com.tencent.mm.sdk.b.a.sFg.c(this.jgg);
        com.tencent.mm.sdk.b.a.sFg.c(this.jgh);
        com.tencent.mm.sdk.b.a.sFg.c(this.jgi);
        com.tencent.mm.sdk.b.a.sFg.c(this.jgj);
        if (this.jgl != null) {
            c.abort();
            c.release();
            this.jgl = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.jgk);
    }

    public static c aMX() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aMW().jgl == null) {
            aMW().jgl = new c();
        }
        return aMW().jgl;
    }

    private static void aMY() {
        k kVar;
        if (com.tencent.d.b.a.cFN()) {
            kVar = new com.tencent.mm.plugin.fingerprint.b.k();
        } else {
            kVar = new com.tencent.mm.plugin.fingerprint.b.d();
        }
        kVar.aNj();
        com.tencent.mm.kernel.g.a(k.class, kVar);
    }
}
