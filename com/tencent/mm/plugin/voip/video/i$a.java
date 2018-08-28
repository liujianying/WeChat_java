package com.tencent.mm.plugin.voip.video;

class i$a implements Runnable {
    private long dkB;
    private int jxE;
    final /* synthetic */ i oVi;
    private boolean oVn;
    private int streamType;

    public i$a(i iVar, int i, long j, boolean z, int i2) {
        this.oVi = iVar;
        this.jxE = i;
        this.dkB = j;
        this.oVn = z;
        this.streamType = i2;
    }

    public final void run() {
        this.oVi.a(this.jxE, this.dkB, this.oVn, this.streamType);
    }
}
