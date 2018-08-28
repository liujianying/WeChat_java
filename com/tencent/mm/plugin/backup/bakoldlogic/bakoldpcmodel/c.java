package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public int dBM;
    public int gZt;
    public int gZu;
    private int gZv;
    int gZw;
    int gZx;
    int gZy;
    public int gZz;

    private void reset() {
        this.gZt = 0;
        this.gZu = 0;
        this.dBM = 0;
        this.gZv = 0;
        this.gZw = 0;
        this.gZx = 0;
        this.gZy = 0;
        this.gZz = 0;
    }

    public final void IF() {
        if (this.gZt == 0) {
            reset();
            return;
        }
        x.i("MicroMsg.BakPCReportor", "report: %s", new Object[]{String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.gZt), Integer.valueOf(this.gZu), Integer.valueOf(this.dBM), Integer.valueOf(this.gZv), Integer.valueOf(this.gZw), Integer.valueOf(this.gZx), Integer.valueOf(this.gZy), Integer.valueOf(this.gZz)})});
        h.mEJ.k(11103, r0);
        reset();
    }
}
