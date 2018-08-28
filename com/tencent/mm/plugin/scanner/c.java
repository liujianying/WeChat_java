package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.af.a.b;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;

public final class c implements ar {
    private static HashMap<Integer, d> cVM;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> hsC = new HashMap();
    public String dqp;
    private a hsE;
    public b mFg = new b();
    private j mFh = new j();
    private n mFi = new n();
    private m mFj = new m();
    private com.tencent.mm.plugin.scanner.history.a.b mFk;
    private com.tencent.mm.plugin.scanner.a.b mFl = new com.tencent.mm.plugin.scanner.a.b();

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new 2());
    }

    public static c brY() {
        au.HN();
        c cVar = (c) bs.iK("plugin.scanner");
        if (cVar != null) {
            return cVar;
        }
        cVar = new c();
        au.HN().a("plugin.scanner", cVar);
        return cVar;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.mFh);
        com.tencent.mm.sdk.b.a.sFg.c(this.mFi.mGl);
        com.tencent.mm.sdk.b.a.sFg.c(this.mFi.mGm);
        com.tencent.mm.sdk.b.a.sFg.c(this.mFj);
        com.tencent.mm.plugin.scanner.a.b bVar = this.mFl;
        com.tencent.mm.sdk.b.a.sFg.c(bVar.mFI);
        com.tencent.mm.sdk.b.a.sFg.c(bVar.mFJ);
        bVar.bsa();
        b bVar2 = this.mFg;
        bVar2.dWH.clear();
        bVar2.miS.clear();
        bVar2.miT.clear();
        if (this.hsE != null) {
            this.hsE.iQ(hashCode());
            this.hsE = null;
        }
        this.dqp = "";
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        this.hsE = u.a(hashCode(), stringBuilder.append(com.tencent.mm.model.c.Gp()).append("CommonOneMicroMsg.db").toString(), hsC, false);
        com.tencent.mm.plugin.scanner.a.b bVar = this.mFl;
        com.tencent.mm.sdk.b.a.sFg.b(bVar.mFI);
        com.tencent.mm.sdk.b.a.sFg.b(bVar.mFJ);
        com.tencent.mm.sdk.b.a.sFg.b(this.mFh);
        com.tencent.mm.sdk.b.a.sFg.b(this.mFi.mGl);
        com.tencent.mm.sdk.b.a.sFg.b(this.mFi.mGm);
        com.tencent.mm.sdk.b.a.sFg.a(this.mFj);
        au.Em().H(new Runnable() {
            public final void run() {
                if (!au.HX()) {
                    return;
                }
                if (bi.oW(c.this.dqp)) {
                    x.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                } else {
                    bi.g(c.this.dqp + "image/scan/img", "scanbook", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void bo(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onSdcardMount ");
        au.HU();
        x.d("MicroMsg.scanner.SubCoreScanner", stringBuilder.append(com.tencent.mm.model.c.Gq()).toString());
        c brY = brY();
        au.HU();
        String Gq = com.tencent.mm.model.c.Gq();
        x.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : " + Gq);
        brY.dqp = Gq;
        File file = new File(Gq);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(Gq + "image/scan/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(Gq + "image/scan/music");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String Gq() {
        return brY().dqp;
    }

    public final String eq(String str, String str2) {
        if (!au.HX() || bi.oW(str)) {
            return "";
        }
        return String.format("%s/scanbook%s_%s", new Object[]{this.dqp + "image/scan/img", str2, g.u(str.getBytes())});
    }

    public static com.tencent.mm.plugin.scanner.history.a.b brZ() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (brY().mFk == null) {
            c brY = brY();
            au.HU();
            brY.mFk = new com.tencent.mm.plugin.scanner.history.a.b(com.tencent.mm.model.c.FO());
        }
        return brY().mFk;
    }
}
