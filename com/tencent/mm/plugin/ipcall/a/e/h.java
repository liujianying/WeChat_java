package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.sdk.platformtools.bi;

public final class h extends a {
    private long krK;
    public long krL;
    private long ksg = 0;
    public long ksh = 0;
    public long ksi = 0;
    public long ksj = 0;

    public final void start() {
        super.start();
        this.krK = bi.VF();
    }

    public final void reset() {
        this.krK = 0;
        this.krL = 0;
        this.ksg = 0;
        this.ksh = 0;
        this.ksi = 0;
        this.ksj = 0;
    }

    protected final void aXS() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(12931, new Object[]{Long.valueOf(this.krK), Long.valueOf(this.krL), Long.valueOf(this.ksg), Long.valueOf(this.ksh), Long.valueOf(this.ksi), Long.valueOf(this.ksj)});
    }
}
