package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    private String bGG;
    public b grT;
    public int grU;
    public String grV;
    private long grW;
    public a grX;

    public final String toString() {
        return "kv_13917{scene=" + this.grT.value + ", appCount=" + this.grU + ", nearbyListId='" + this.grV + '\'' + ", clickTime=" + this.grW + ", sceneNote='" + this.bGG + '\'' + ", openType=" + this.grX.value + '}';
    }

    public final void xP() {
        if (this.grT != null && this.grX != null) {
            x.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
            this.grW = bi.VF();
            h.mEJ.h(13917, e.j(new Object[]{Integer.valueOf(this.grT.value), Integer.valueOf(this.grU), this.grV, Long.valueOf(this.grW), this.bGG, Integer.valueOf(this.grX.value)}));
        }
    }
}
