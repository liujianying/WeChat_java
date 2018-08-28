package com.tencent.mm.sdk.platformtools;

class bd$1 implements Runnable {
    final /* synthetic */ bd sJf;

    bd$1(bd bdVar) {
        this.sJf = bdVar;
    }

    public final void run() {
        x.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + this.sJf.sJe);
        if (this.sJf.sJe) {
            this.sJf.run();
        } else {
            this.sJf.cf(this.sJf.run());
        }
        this.sJf.sJd = bi.bI(this.sJf.dCL);
    }
}
