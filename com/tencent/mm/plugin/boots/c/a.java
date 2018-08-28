package com.tencent.mm.plugin.boots.c;

import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a implements f {
    public static a hjJ;
    private com.tencent.mm.plugin.boots.c.a.a hjK;

    public a(com.tencent.mm.plugin.boots.c.a.a aVar) {
        this.hjK = aVar;
    }

    public final void c(int i, boolean z, int i2) {
        int i3 = 255;
        if (this.hjK != null) {
            com.tencent.mm.plugin.boots.a.a nf = this.hjK.nf(i);
            int ne = this.hjK.ne(i);
            if (z && nf.field_dau != ne) {
                if (ne <= 255) {
                    i3 = ne;
                }
                h.mEJ.a((long) i2, (long) i3, 1, false);
                return;
            }
            return;
        }
        x.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
    }

    public final List<com.tencent.mm.plugin.boots.a.a> aua() {
        if (this.hjK != null) {
            return this.hjK.aua();
        }
        return null;
    }
}
