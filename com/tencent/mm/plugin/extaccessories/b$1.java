package com.tencent.mm.plugin.extaccessories;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b iLy;

    b$1(b bVar) {
        this.iLy = bVar;
    }

    public final void run() {
        if (au.HX() && !bi.oW(this.iLy.dqp)) {
            long currentTimeMillis = System.currentTimeMillis();
            bi.g(this.iLy.dqp + "image/spen/", "spen_", 259200000);
            x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }
}
