package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.plugin.exdevice.model.c.1;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ c itb;
    final /* synthetic */ ae itc;

    c$2(c cVar, ae aeVar) {
        this.itb = cVar;
        this.itc = aeVar;
    }

    public final void run() {
        boolean z = true;
        c cVar = this.itb;
        ae aeVar = this.itc;
        if (cVar.isY == null) {
            x.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
            if (cVar.isZ != null) {
                x.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                cVar.isZ.aGL();
                new al(Looper.getMainLooper(), new 1(cVar), true).J(100, 100);
            } else {
                x.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
            }
            z = false;
        }
        if (z) {
            aeVar.a(cVar.isY, cVar);
        } else {
            cVar.ita.add(aeVar);
        }
    }
}
