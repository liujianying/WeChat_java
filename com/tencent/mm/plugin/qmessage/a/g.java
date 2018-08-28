package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

public final class g implements ar {
    private static HashMap<Integer, d> cVM;
    private e mbC;
    private f mbD = new f();
    private a mbE = new a();
    private b mbF = new b();

    private static g bob() {
        au.HN();
        g gVar = (g) bs.iK("plugin.qmessage");
        if (gVar != null) {
            return gVar;
        }
        gVar = new g();
        au.HN().a("plugin.qmessage", gVar);
        return gVar;
    }

    public static e boc() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bob().mbC == null) {
            g bob = bob();
            au.HU();
            bob.mbC = new e(c.FO());
        }
        return bob().mbC;
    }

    public final void onAccountRelease() {
        com.tencent.mm.ab.d.c.b(Integer.valueOf(36), this.mbD);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(39), this.mbD);
        a.sFg.c(this.mbE);
        a.sFg.c(this.mbF);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
        x.d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i & 32) != 0) {
            boe();
        }
    }

    public static void bod() {
        au.HU();
        if (c.FW().Yq("qmessage") == null) {
            ai aiVar = new ai();
            aiVar.setUsername("qmessage");
            aiVar.setContent("");
            aiVar.as(bi.VF());
            aiVar.eX(0);
            aiVar.eV(0);
            au.HU();
            c.FW().d(aiVar);
            return;
        }
        au.HU();
        bd GE = c.FT().GE("qmessage");
        ai aiVar2 = new ai();
        aiVar2.setUsername("qmessage");
        aiVar2.setContent(GE == null ? "" : GE.field_content);
        aiVar2.as(bi.VF());
        aiVar2.eX(0);
        aiVar2.eV(0);
        au.HU();
        c.FW().a(aiVar2, "qmessage");
    }

    public static void boe() {
        com.tencent.mm.model.bd.Im();
        au.HU();
        c.FW().GL("@qqim");
        au.HU();
        c.FW().Yp("qmessage");
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(36), this.mbD);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(39), this.mbD);
        a.sFg.b(this.mbE);
        a.sFg.b(this.mbF);
    }

    public final void bo(boolean z) {
    }
}
