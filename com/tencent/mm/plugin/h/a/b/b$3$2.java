package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.h.a.b.b.3;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class b$3$2 implements Runnable {
    final /* synthetic */ 3 hfP;

    b$3$2(3 3) {
        this.hfP = 3;
    }

    public final void run() {
        if (!this.hfP.hfM.hfJ.isEmpty()) {
            Iterator it = this.hfP.hfM.hfJ.iterator();
            while (it.hasNext()) {
                x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                if (this.hfP.hfM.hfE != null) {
                    this.hfP.hfM.hfE.i(r0.longValue(), false);
                }
            }
            this.hfP.hfM.hfJ.clear();
        }
    }
}
