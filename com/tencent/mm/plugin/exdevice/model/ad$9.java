package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class ad$9 implements b {
    final /* synthetic */ ad iwz;

    ad$9(ad adVar) {
        this.iwz = adVar;
    }

    public final void a(int i, m mVar, Object obj) {
        try {
            if (!au.HX()) {
                x.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
            } else if (obj instanceof String) {
                au.Em().h(new 1(this, obj), 2000);
            }
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[]{e.getMessage()});
        }
    }
}
