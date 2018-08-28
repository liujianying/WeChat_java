package com.tencent.mm.plugin.h.a.c;

final class a$b implements Runnable {
    private long hfQ = 0;
    private long hfR = 0;
    final /* synthetic */ a hiK;

    public a$b(a aVar, long j, long j2) {
        this.hiK = aVar;
        this.hfQ = j;
        this.hfR = j2;
    }

    public final void run() {
        a aVar = this.hiK;
        b bVar = new b(this.hfQ);
        long j = bVar.mSessionId;
        b bVar2 = (b) aVar.hfF.remove(Long.valueOf(j));
        if (bVar2 != null) {
            bVar2.disconnect();
        }
        aVar.hfF.put(Long.valueOf(j), bVar);
        if (this.hiK.hiH != null) {
            this.hiK.hiH.b(j, this.hfQ, this.hfR);
        }
    }
}
