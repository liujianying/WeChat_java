package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.a.by;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$a$2$2 extends c<by> {
    final /* synthetic */ 2 gfd;

    AppBrandPrepareTask$a$2$2(2 2) {
        this.gfd = 2;
        this.sFo = by.class.getName().hashCode();
    }

    private boolean a(by byVar) {
        if (byVar != null) {
            dead();
            x.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
        }
        this.gfd.gfc.akB();
        return false;
    }
}
