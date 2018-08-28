package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class j extends a {
    private long krK;
    public long krL;
    public long ksk = 0;
    public long ksl = 0;
    public long ksm = 0;

    public final void start() {
        super.start();
        this.krK = bi.VF();
    }

    public final void reset() {
        this.krK = 0;
        this.krL = 0;
        this.ksk = 0;
        this.ksl = 0;
        this.ksm = 0;
    }

    protected final void aXS() {
        h.mEJ.h(12934, new Object[]{Long.valueOf(this.krK), Long.valueOf(this.krL), Long.valueOf(this.ksk), Long.valueOf(this.ksl), Long.valueOf(this.ksm)});
    }
}
