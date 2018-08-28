package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class b extends a {
    private long krK;
    public long krL;
    public long krM = 0;
    public long krN = 0;
    public long krO = 0;

    public final void start() {
        super.start();
        this.krK = bi.VF();
    }

    public final void reset() {
        this.krK = 0;
        this.krL = 0;
        this.krM = 0;
        this.krN = 0;
        this.krO = 0;
    }

    protected final void aXS() {
        h.mEJ.h(12930, new Object[]{Long.valueOf(this.krK), Long.valueOf(this.krL), Long.valueOf(this.krM), Long.valueOf(this.krN), Long.valueOf(this.krO)});
    }
}
