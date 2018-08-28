package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.e.b;
import com.tencent.mm.plugin.appbrand.page.p.g;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements g {
    final /* synthetic */ long cXh;
    final /* synthetic */ p fGY;
    final /* synthetic */ b gmA;
    final /* synthetic */ e gmz;

    e$3(e eVar, p pVar, b bVar, long j) {
        this.gmz = eVar;
        this.fGY = pVar;
        this.gmA = bVar;
        this.cXh = j;
    }

    public final void onReady() {
        this.fGY.b(this);
        this.gmA.run();
        long currentTimeMillis = System.currentTimeMillis() - this.cXh;
        x.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", new Object[]{Long.valueOf(currentTimeMillis)});
    }
}
