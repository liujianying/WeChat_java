package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.f.b;

class b$2 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ int gRU;
    final /* synthetic */ boolean gRW;
    final /* synthetic */ byte[] gRX;
    final /* synthetic */ b gZs;

    b$2(b bVar, boolean z, int i, int i2, byte[] bArr) {
        this.gZs = bVar;
        this.gRW = z;
        this.gRU = i;
        this.bpX = i2;
        this.gRX = bArr;
    }

    public final void run() {
        b.b(this.gRW, this.gRU, this.bpX, this.gRX);
    }
}
