package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ee;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$10 extends c<ee> {
    final /* synthetic */ e iup;

    e$10(e eVar) {
        this.iup = eVar;
        this.sFo = ee.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ee eeVar = (ee) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", new Object[]{eeVar.bMa.byN, Integer.valueOf(eeVar.bMa.direction), Boolean.valueOf(eeVar.bMa.clear)});
        if (eeVar.bMa.clear) {
            k.aGF().isK.clear();
            eeVar.bMb.bKE = true;
        } else if (bi.oW(eeVar.bMa.byN)) {
            eeVar.bMb.bKE = false;
        } else {
            k aGF = k.aGF();
            String str = eeVar.bMa.byN;
            int i = eeVar.bMa.direction;
            if (!bi.oW(str)) {
                aGF.isK.put(str, Integer.valueOf(i));
            }
            eeVar.bMb.bKE = true;
        }
        return true;
    }
}
