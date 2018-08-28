package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.appusage.j.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

public final class j$b implements a {
    private static final j$b flT = new j$b();

    static /* synthetic */ void rl(String str) {
        x.i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", new Object[]{Boolean.valueOf(g.Eg().Dx()), str});
        if (g.Eg().Dx()) {
            Map z = bl.z(str, "sysmsg");
            if (z != null && z.size() > 0) {
                String str2 = (String) z.get(".sysmsg.wxareddot.id");
                int i = bi.getInt((String) z.get(".sysmsg.wxareddot.activitytype"), 0);
                if (!bi.oW(str2)) {
                    if (i == 1 || i == 2) {
                        int i2 = bi.getInt((String) z.get(".sysmsg.wxareddot.close"), 0);
                        long j = bi.getLong((String) z.get(".sysmsg.wxareddot.pushtime"), 0);
                        long j2 = bi.getLong((String) z.get(".sysmsg.wxareddot.duration"), 0);
                        long j3 = bi.getLong((String) z.get(".sysmsg.wxareddot.frequency"), 0);
                        z.get(".sysmsg.wxareddot.tips");
                        int i3 = bi.getInt((String) z.get(".sysmsg.wxareddot.showType"), 0);
                        int i4 = bi.getInt((String) z.get(".sysmsg.wxareddot.reason"), 0);
                        switch (i) {
                            case 1:
                                if (!str2.equals((String) g.Ei().DT().get(aa.a.sTF, null)) && !b.acG() && !bi.bQ(ad.getContext()).equals(AppBrandLauncherUI.class.getName()) && i.acQ() != i.a.flK) {
                                    g.Ei().DT().a(aa.a.sTF, str2);
                                    g.Ei().DT().a(aa.a.sTG, Long.valueOf(j));
                                    g.Ei().DT().a(aa.a.sTH, Integer.valueOf(i3));
                                    g.Ei().DT().a(aa.a.sTI, Integer.valueOf(i4));
                                    if (i2 == 1 && j.acZ()) {
                                        e eVar = e.fma;
                                        e.a((String) g.Ei().DT().get(aa.a.sTF, ""), ((Long) g.Ei().DT().get(aa.a.sTG, Long.valueOf(0))).longValue(), 4, e.ade());
                                    }
                                    j.b(i2 != 1, j2);
                                    return;
                                }
                                return;
                            case 2:
                                if (!str2.equals((String) g.Ei().DT().get(aa.a.sTM, null))) {
                                    j.b(i2 != 1, j2, j3);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private j$b() {
    }

    public static void adc() {
        i.acO();
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("wxareddot", flT, true);
    }

    public static void unregister() {
        i.acO();
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("wxareddot", flT, true);
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (!bi.oW(a)) {
            c.Em().H(new 1(this, a));
        }
    }
}
