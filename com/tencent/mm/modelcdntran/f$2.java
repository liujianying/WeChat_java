package com.tencent.mm.modelcdntran;

class f$2 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ j dPD;

    f$2(f fVar, j jVar) {
        this.dPC = fVar;
        this.dPD = jVar;
    }

    public final void run() {
        this.dPC.dOU.add(this.dPD.field_mediaId);
        this.dPC.dOV.put(this.dPD.field_mediaId, this.dPD);
        this.dPC.bH(false);
    }
}
