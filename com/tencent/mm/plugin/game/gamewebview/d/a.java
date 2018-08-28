package com.tencent.mm.plugin.game.gamewebview.d;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public d jGU;
    private String jIl;
    private int jIm = ao.getNetType(ad.getContext());
    private int jIn;
    public int jIo;
    public boolean jIp;
    public long jIq;
    public long jIr;
    public long jIs;
    public long jIt;
    public long jIu;

    public a(d dVar) {
        this.jGU = dVar;
        this.jIn = dVar.getWebView().getIsX5Kernel() ? 1 : 2;
        this.jIq = System.currentTimeMillis();
        this.jIl = this.jGU.getRawUrl();
    }

    public final void fn(boolean z) {
        long j;
        int i = 1;
        x.d("MicroMsg.GameWebViewReportManager", "getA8keyTime = %d, success = %b", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jIt), Boolean.valueOf(z)});
        String currentURL = this.jGU.getCurrentURL();
        if (!z) {
            i = 0;
        }
        a(currentURL, 3, r4, i, 0);
        h hVar = h.mEJ;
        if (z) {
            j = 2;
        } else {
            j = 1;
        }
        hVar.a(607, j, 1, false);
    }

    public final void a(String str, int i, long j, int i2, int i3) {
        h.mEJ.h(14531, new Object[]{this.jGU.getCacheAppId(), an.Dx(this.jIl), an.Dx(str), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.jIm), Integer.valueOf(this.jIn), Integer.valueOf(i3)});
    }
}
