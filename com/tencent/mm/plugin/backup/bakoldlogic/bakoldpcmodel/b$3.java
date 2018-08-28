package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

class b$3 implements Runnable {
    final /* synthetic */ byte[] bAa;
    final /* synthetic */ int gRU;
    final /* synthetic */ b gZs;

    b$3(b bVar, int i, byte[] bArr) {
        this.gZs = bVar;
        this.gRU = i;
        this.bAa = bArr;
    }

    public final void run() {
        this.gZs.Z(this.bAa);
    }
}
