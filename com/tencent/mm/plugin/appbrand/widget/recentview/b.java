package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public long gOW = 0;
    public int gOX;
    private int gOY;
    private int gOZ;
    public int gPa;
    public int gPb;
    public int gPc;
    public StringBuilder gPd = new StringBuilder();
    public StringBuilder gPe = new StringBuilder();

    public final void cc(int i, int i2) {
        this.gOY = i;
        this.gOZ = i2;
        if (this.gOW <= 0) {
            x.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
            return;
        }
        x.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime:%s mCountAtOpen:%s mCountAtClose:%s mCloseType:%s mScrollCount:%s mOpenAppBrandList:%s mDeleteCount:%s mDeleteAppBrandList:%s", new Object[]{Long.valueOf(this.gOW), Integer.valueOf(this.gOX), Integer.valueOf(this.gOY), Integer.valueOf(this.gOZ), Integer.valueOf(this.gPa), this.gPd.toString(), Integer.valueOf(this.gPb), this.gPe.toString()});
        h.mEJ.h(15081, new Object[]{Long.valueOf(this.gOW), Integer.valueOf(this.gOX), Integer.valueOf(this.gOY), Integer.valueOf(this.gOZ), Integer.valueOf(this.gPa), this.gPd.toString(), Integer.valueOf(this.gPb), this.gPe.toString(), Integer.valueOf(this.gPc)});
        this.gOW = 0;
        this.gPb = 0;
        this.gPa = 0;
        this.gOZ = 0;
        this.gOY = 0;
        this.gOX = 0;
        this.gPd = new StringBuilder();
        this.gPe = new StringBuilder();
    }
}
