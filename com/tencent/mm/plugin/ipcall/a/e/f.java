package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;

public final class f extends a {
    public int krR = 0;
    public int krS = 0;
    public int krT = 0;
    public int krU = 0;
    public int krV = -9999;
    public String krW = "";
    public int krX = 0;
    public int krY = 0;

    public final void start() {
        super.start();
    }

    public final void reset() {
        this.krR = 0;
        this.krS = 0;
        this.krT = 0;
        this.krU = 0;
        this.krV = -9999;
        this.krW = "";
        this.krX = 0;
        this.krY = 0;
    }

    protected final void aXS() {
        h.mEJ.h(14182, new Object[]{Integer.valueOf(this.krR), Integer.valueOf(this.krS), Integer.valueOf(this.krT), Integer.valueOf(this.krU), Integer.valueOf(this.krV), this.krW, Integer.valueOf(this.krX), Integer.valueOf(this.krY)});
    }
}
