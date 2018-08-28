package com.tencent.mm.modelcdntran;

class f$3 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ j dPD;

    f$3(f fVar, j jVar) {
        this.dPC = fVar;
        this.dPD = jVar;
    }

    public final void run() {
        this.dPC.dOU.add(this.dPD.field_mediaId);
        this.dPC.dOV.put(this.dPD.field_mediaId, this.dPD);
        this.dPC.bH(false);
    }
}
