package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashMap;

public final class d implements ar {
    private final c<aw> ijI = new 1(this);
    private final h kmA = new h();
    private final c<cm> kmB = new 2(this);
    private final f kmC = new f();
    private final c<bf> kmD = new 3(this);
    boolean kmz = true;

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        b.a(new g(), new String[]{"//tinker"});
        au.getSysCmdMsgExtension().a("checktinkerupdate", this.kmA, true);
        a.sFg.b(this.ijI);
        this.kmB.cht();
        a.sFg.b(this.kmC);
        a.sFg.b(this.kmD);
        x.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        g.dI(ad.getContext());
        try {
            au.HU();
            long longValue = ((Long) com.tencent.mm.model.c.DT().get(aa.a.sXW, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= 3600000) {
                com.tinkerboots.sdk.a.cJC().na(true);
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sXW, Long.valueOf(currentTimeMillis));
                x.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue)});
            } else {
                com.tinkerboots.sdk.a.cJC().na(false);
                x.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            f.dM(currentTimeMillis);
        } catch (Throwable e) {
            x.printErrStackTrace("Tinker.SubCoreHotpatch", e, "", new Object[0]);
        }
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        b.D(new String[]{"//tinker"});
        au.getSysCmdMsgExtension().b("checktinkerupdate", this.kmA, true);
        a.sFg.c(this.ijI);
        this.kmB.dead();
        a.sFg.c(this.kmC);
        a.sFg.c(this.kmD);
        x.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    }
}
