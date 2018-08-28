package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ e hgr;
    final /* synthetic */ long hgw;

    public e$5(e eVar, long j) {
        this.hgr = eVar;
        this.hgw = j;
    }

    public final void run() {
        f fVar = (f) this.hgr.hfF.remove(Long.valueOf(this.hgw));
        if (fVar != null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", new Object[]{b.cY(fVar.mSessionId), fVar.fNN.getName()});
            if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(2))) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
            }
            this.hgr.hgp.put(Long.valueOf(this.hgw), Boolean.valueOf(true));
            return;
        }
        x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
    }
}
