package com.tencent.mm.plugin.ab;

import com.tencent.mm.ab.l;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.f;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bi;
import java.util.HashMap;

public final class a extends p implements com.tencent.mm.kernel.api.bucket.a, c {
    private static HashMap<Integer, d> cVM;
    private static a lEC;
    private com.tencent.mm.ao.d lED = null;
    private bi lEE = null;
    private com.tencent.mm.ao.c lEF = null;
    private e lEG = new e();
    private final com.tencent.mm.ab.e lEH = new com.tencent.mm.ab.e() {
        public final void a(int i, int i2, String str, l lVar) {
        }
    };

    private a() {
        super(f.class);
    }

    public static synchronized a bjh() {
        a aVar;
        synchronized (a.class) {
            if (lEC == null) {
                lEC = new a();
            }
            aVar = lEC;
        }
        return aVar;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new 2());
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        super.onAccountInitialized(cVar);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("newtips", this.lEG);
        g.DF().a(597, this.lEH);
        bji();
        com.tencent.mm.ao.d.b(b.ebm, b.ebl, "", b.ebt);
        x.i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", new Object[]{Integer.valueOf(r0), r1});
    }

    public final void onAccountRelease() {
        super.onAccountRelease();
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("newtips", this.lEG);
        g.DF().b(597, this.lEH);
    }

    public static com.tencent.mm.ao.d bji() {
        g.Eg().Ds();
        if (bjh().lED == null) {
            bjh().lED = new com.tencent.mm.ao.d();
        }
        return bjh().lED;
    }

    public static bi bjj() {
        g.Eg().Ds();
        if (bjh().lEE == null) {
            a bjh = bjh();
            g.Ek();
            bjh.lEE = new bi(g.Ei().dqq);
        }
        return bjh().lEE;
    }

    public static com.tencent.mm.ao.c bjk() {
        g.Eg().Ds();
        if (bjh().lEF == null) {
            bjh().lEF = new com.tencent.mm.ao.c();
        }
        return bjh().lEF;
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return cVM;
    }
}
