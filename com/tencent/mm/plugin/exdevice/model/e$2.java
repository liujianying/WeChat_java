package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dl;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.d.5;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends c<dl> {
    final /* synthetic */ e iup;

    e$2(e eVar) {
        this.iup = eVar;
        this.sFo = dl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dl dlVar = (dl) bVar;
        if (dlVar != null && (dlVar instanceof dl)) {
            dlVar = dlVar;
            String str = dlVar.bLj.bLl;
            boolean z = dlVar.bLj.bLi;
            d aHl = ad.aHl();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
            au.Em().H(new 5(aHl, str, z));
        }
        return true;
    }
}
