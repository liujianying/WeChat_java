package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.f.b;

class a$5 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ a gRT;
    final /* synthetic */ int gRU;
    final /* synthetic */ boolean gRW;
    final /* synthetic */ byte[] gRX;

    a$5(a aVar, boolean z, int i, int i2, byte[] bArr) {
        this.gRT = aVar;
        this.gRW = z;
        this.gRU = i;
        this.bpX = i2;
        this.gRX = bArr;
    }

    public final void run() {
        b.b(this.gRW, this.gRU, this.bpX, this.gRX);
    }
}
