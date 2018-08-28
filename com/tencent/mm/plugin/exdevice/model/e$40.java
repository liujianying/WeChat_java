package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class e$40 implements a {
    final /* synthetic */ e iup;

    e$40(e eVar) {
        this.iup = eVar;
    }

    public final void a(long j, int i, int i2, int i3, long j2) {
        List<b> linkedList;
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
        e eVar = this.iup;
        String cY = com.tencent.mm.plugin.exdevice.j.b.cY(j);
        synchronized (eVar.itw) {
            linkedList = new LinkedList(eVar.itw);
        }
        for (b d : linkedList) {
            d.d(cY, i2, j2);
        }
        linkedList.clear();
        for (b d2 : eVar.itx.values()) {
            d2.d(cY, i2, j2);
        }
        ei eiVar = new ei();
        eiVar.bMj.mac = cY;
        eiVar.bMj.bLv = i2;
        eiVar.bMj.bMg = j2;
        com.tencent.mm.sdk.b.a.sFg.a(eiVar, Looper.getMainLooper());
    }
}
