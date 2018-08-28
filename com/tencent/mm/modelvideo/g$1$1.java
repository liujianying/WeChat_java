package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.g.1;
import com.tencent.mm.modelvideo.h.a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

class g$1$1 implements a {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ 1 emB;

    g$1$1(1 1, keep_SceneResult keep_sceneresult) {
        this.emB = 1;
        this.dPf = keep_sceneresult;
    }

    public final void bp(int i, int i2) {
        if (i == 4 && i2 == s$l.AppCompatTheme_checkboxStyle) {
            g.Em().H(new 1(this));
            return;
        }
        h.mEJ.h(10421, new Object[]{Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(g.d(this.emB.emA)), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(g.e(this.emB.emA)), Integer.valueOf(this.dPf.field_fileLength), this.dPf.field_transInfo, "", "", "", "", "", "", "", this.dPf.report_Part2});
        a.a(g.g(this.emB.emA), 0);
        g.a(this.emB.emA, this.dPf);
        g.f(this.emB.emA).a(i, i2, "", this.emB.emA);
    }
}
