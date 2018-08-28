package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.8;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;

class CleanNewUI$6 implements c {
    final /* synthetic */ CleanNewUI hTh;

    CleanNewUI$6(CleanNewUI cleanNewUI) {
        this.hTh = cleanNewUI;
    }

    public final void co(int i, int i2) {
        if (!CleanNewUI.f(this.hTh)) {
            this.hTh.cr(i, i2);
        }
    }

    public final void a(long j, long j2, long j3, HashSet<String> hashSet, HashMap<String, Long> hashMap) {
        CleanNewUI.a(this.hTh, bi.VF());
        CleanNewUI cleanNewUI = this.hTh;
        j.aBt().hQC = j;
        j.aBt().hQD = j2;
        j.aBt().hQE = j3;
        j.aBt().hRp = hashMap;
        j.aBt().hRd = hashSet;
        ah.A(new 8(cleanNewUI, j));
        h.mEJ.a(714, 53, 1, false);
        long g = CleanNewUI.g(this.hTh) - CleanNewUI.h(this.hTh);
        long i = CleanNewUI.i(this.hTh) - CleanNewUI.j(this.hTh);
        x.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[]{Long.valueOf(CleanNewUI.g(this.hTh)), Long.valueOf(CleanNewUI.h(this.hTh)), Long.valueOf(g), Long.valueOf(CleanNewUI.i(this.hTh)), Long.valueOf(CleanNewUI.j(this.hTh)), Long.valueOf(i), Long.valueOf(g + i)});
        h.mEJ.h(14556, new Object[]{Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.h(this.hTh)), Long.valueOf(CleanNewUI.g(this.hTh)), Long.valueOf(g)});
        h.mEJ.h(14556, new Object[]{Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.j(this.hTh)), Long.valueOf(CleanNewUI.i(this.hTh)), Long.valueOf(i)});
        h.mEJ.h(14556, new Object[]{Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(g + i)});
    }
}
