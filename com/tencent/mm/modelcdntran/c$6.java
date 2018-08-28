package com.tencent.mm.modelcdntran;

class c$6 implements Runnable {
    final /* synthetic */ c dPb;
    final /* synthetic */ i dPd;

    c$6(c cVar, i iVar) {
        this.dPb = cVar;
        this.dPd = iVar;
    }

    public final void run() {
        this.dPb.dOU.add(this.dPd.field_mediaId);
        this.dPb.dOV.put(this.dPd.field_mediaId, this.dPd);
        this.dPb.bH(false);
    }

    public final String toString() {
        return super.toString() + "|addSendTask";
    }
}
