package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.q;

class AppBrandProfile$3 extends q {
    final /* synthetic */ AppBrandProfile bxZ;

    AppBrandProfile$3(AppBrandProfile appBrandProfile) {
        this.bxZ = appBrandProfile;
    }

    public final void am(long j) {
        x.v("MicroMsg.AppBrandProfile", "callback: idkeyStat:577, " + j + ", 1");
        h.mEJ.a(577, j, 1, true);
    }

    public final void w(int i, int i2, int i3) {
        x.v("MicroMsg.AppBrandProfile", "callback: idkeyForPair:577, " + i + ", 1, 577, " + i2 + ", " + i3);
        h.mEJ.a(577, 577, i, i2, 1, i3, true);
    }

    public final void k(int i, String str) {
        x.v("MicroMsg.AppBrandProfile", "callback: kvStat:" + i + ", " + str);
        h.mEJ.k(i, str);
    }

    public final void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        x.v("MicroMsg.AppBrandProfile", "callback: kvStat:15003, 21," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
        h.mEJ.h(15003, new Object[]{Integer.valueOf(21), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(ao.getNetType(AppBrandProfile.a(this.bxZ).getBaseContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
    }
}
