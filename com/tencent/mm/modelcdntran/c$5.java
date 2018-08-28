package com.tencent.mm.modelcdntran;

class c$5 implements Runnable {
    final /* synthetic */ c dPb;
    final /* synthetic */ int dPc;
    final /* synthetic */ i dPd;

    c$5(c cVar, int i, i iVar) {
        this.dPb = cVar;
        this.dPc = i;
        this.dPd = iVar;
    }

    public final void run() {
        if (this.dPc != -1) {
            this.dPb.dOX.put(this.dPd.field_mediaId, Integer.valueOf(this.dPc));
        }
        this.dPb.dOU.add(this.dPd.field_mediaId);
        this.dPb.dOV.put(this.dPd.field_mediaId, this.dPd);
        this.dPb.bH(false);
    }

    public final String toString() {
        return super.toString() + "|addRecvTask";
    }
}
