package com.tencent.mm.plugin.u;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class g {
    public long aeq = 0;
    private boolean hEj;
    public long lcT = 0;
    public long lcU = 0;
    public long lcV = -1;
    public long lcW = 0;
    public long lcX = 0;
    public long lcY = 0;
    public long lcZ = 10;
    public boolean lda = true;
    public boolean ldb = true;
    public boolean ldc = false;
    public boolean ldd = false;
    boolean lde = false;
    boolean ldf = false;

    public g(boolean z) {
        this.hEj = z;
    }

    public final String avA() {
        return hashCode();
    }

    public final void Hl(String str) {
        if (this.lda) {
            h.mEJ.a(354, 152, 1, false);
            h.mEJ.h(13836, new Object[]{Integer.valueOf(500), Long.valueOf(bi.VE()), str});
        }
    }

    public final void Hm(String str) {
        if (this.lda) {
            h.mEJ.a(354, 153, 1, false);
            h.mEJ.h(13836, new Object[]{Integer.valueOf(501), Long.valueOf(bi.VE()), str});
        }
    }

    public final void bdv() {
        if (this.lda) {
            h.mEJ.a(354, 155, 1, false);
            h.mEJ.h(13836, new Object[]{Integer.valueOf(503), Long.valueOf(bi.VE()), ""});
        }
    }
}
