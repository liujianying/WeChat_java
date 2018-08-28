package com.tencent.mm.app;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends c<jl> {
    private static boolean byV = false;
    private int byW;
    private int byX;

    public final /* synthetic */ boolean a(b bVar) {
        jl jlVar = (jl) bVar;
        if (jlVar != null) {
            x.w("MicroMsg.MediaLeakReporter", "event audio[%b %d] mediaplayer[%b %d] audioRecord[%b %d] hadRpt[%b]", new Object[]{Boolean.valueOf(jlVar.bTa.bTb), Integer.valueOf(jlVar.bTa.bTc), Boolean.valueOf(jlVar.bTa.bTd), Integer.valueOf(jlVar.bTa.bTe), Boolean.valueOf(jlVar.bTa.bTf), Integer.valueOf(jlVar.bTa.bTg), Boolean.valueOf(byV)});
            if (jlVar.bTa.bTb) {
                h.mEJ.a(650, (long) this.byW, 1, false);
            }
            if (jlVar.bTa.bTd) {
                h.mEJ.a(650, (long) this.byX, 1, false);
            }
            if (jlVar.bTa.bTf) {
                h.mEJ.a(650, (long) (this.byX + 1), 1, false);
            }
            if (!byV && (jlVar.bTa.bTc > 10 || jlVar.bTa.bTe > 10 || jlVar.bTa.bTg > 0)) {
                h.mEJ.c("mediaLeak", f.yS(), null);
                byV = true;
            }
        }
        return false;
    }

    public l(int i, int i2) {
        this.byW = i;
        this.byX = i2;
        this.sFo = jl.class.getName().hashCode();
    }
}
