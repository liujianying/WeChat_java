package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.sdk.platformtools.x;

final class b$b implements Runnable {
    final /* synthetic */ b hfM;
    private long hfQ = 0;
    private long hfR = 0;

    public b$b(b bVar, long j, long j2) {
        this.hfM = bVar;
        this.hfQ = j;
        this.hfR = j2;
    }

    public final void run() {
        b bVar = this.hfM;
        d dVar = new d(this.hfQ, bVar.rc, bVar);
        String valueOf = String.valueOf(dVar.mSessionId);
        x.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[]{Integer.valueOf(dVar.hashCode()), Long.valueOf(r2), valueOf});
        d dVar2 = (d) bVar.hfF.remove(valueOf);
        if (dVar2 != null) {
            dVar2.close();
        }
        bVar.hfF.put(valueOf, dVar);
        long j = dVar.mSessionId;
        if (this.hfM.hfE != null) {
            this.hfM.hfE.b(j, this.hfQ, this.hfR);
        }
    }
}
