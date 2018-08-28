package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

public final class q extends a<ahn> {
    private static final long fmw = TimeUnit.MINUTES.toSeconds(5);

    protected final /* synthetic */ void a(int i, int i2, String str, bhp bhp, l lVar) {
        ahn ahn = (ahn) bhp;
        super.a(i, i2, str, ahn, lVar);
        c abf = e.abf();
        com.tencent.mm.plugin.appbrand.p.a abm = e.abm();
        if (abf == null || abm == null) {
            x.e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", new Object[]{abf, abm});
            return;
        }
        long j = (i == 0 && i2 == 0 && ahn != null) ? (long) ahn.rKN : fmw;
        abf.bd("GetSearchShowOutWxaApp_interval", String.valueOf(j));
        if (i == 0 && i2 == 0 && ahn != null) {
            try {
                abm.m("GetSearchShowOutWxaApp_resp", ahn.toByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", new Object[]{e});
            }
        }
    }

    public static void adh() {
        if (g.Eg().dpD) {
            g.l(d.class);
        }
    }

    static ahn adi() {
        return (ahn) e.abm().g("GetSearchShowOutWxaApp_resp", ahn.class);
    }
}
