package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.backuppcmodel.d.1;

class d$1$1 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ int gRU;
    final /* synthetic */ byte[] gRX;
    final /* synthetic */ 1 gWO;

    d$1$1(1 1, int i, byte[] bArr, int i2) {
        this.gWO = 1;
        this.bpX = i;
        this.gRX = bArr;
        this.gRU = i2;
    }

    public final void run() {
        if (this.bpX == 3) {
            d.a(this.gWO.gWN, this.gRX, this.gRU);
        } else if (this.bpX == 11) {
            d.b(this.gWO.gWN, this.gRX, this.gRU);
        } else if (this.bpX == 6) {
            d.c(this.gWO.gWN, this.gRX, this.gRU);
        } else if (this.bpX == 13) {
            d.I(this.gRX, this.gRU);
        } else if (this.bpX == 15) {
            d.d(this.gWO.gWN, this.gRX, this.gRU);
        } else if (this.bpX == 8) {
            d.a(this.gWO.gWN, this.gRX);
        }
    }
}
