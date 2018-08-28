package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends a {
    private long krK;
    public long krL;
    public long krZ = 0;
    public String ksa = "";
    public String ksb = "";
    public long ksc = 0;
    public long ksd = 0;
    public long kse = 0;
    public String ksf = "";

    public final void start() {
        super.start();
        this.krK = bi.VF();
    }

    public final void reset() {
        this.krK = 0;
        this.krL = 0;
        this.krZ = 0;
        this.ksa = "";
        this.ksb = "";
        this.ksc = 0;
        this.ksd = 0;
        this.kse = 0;
        this.ksf = "";
    }

    protected final void aXS() {
        h.mEJ.h(12933, new Object[]{Long.valueOf(this.krK), Long.valueOf(this.krL), Long.valueOf(this.krZ), this.ksa, this.ksb, Long.valueOf(this.ksc), Long.valueOf(this.ksd), Long.valueOf(this.kse), this.ksf});
    }
}
