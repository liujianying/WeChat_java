package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.aa;

public class PluginReaderApp extends f implements c, a {
    private e mno = new 2(this);

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(o.class);
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            pin(new p(com.tencent.mm.plugin.readerapp.c.g.class));
        }
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.bg.c.Um("readerapp");
        }
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.sdk.f.e.post(new 1(this), "ReaderAppReport");
    }

    private void reportPluginStatus() {
        int i;
        int i2 = checkInstall() ? 1 : 0;
        if (checkRecvNews()) {
            i = 1;
        } else {
            i = 0;
        }
        h.mEJ.h(15416, new Object[]{"newsapp", Integer.valueOf(i2), Integer.valueOf(i)});
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sZU, Long.valueOf(System.currentTimeMillis()));
    }

    public void onAccountRelease() {
        com.tencent.mm.kernel.g.DF().b(138, this.mno);
    }

    private boolean checkInstall() {
        if ((q.GQ() & 524288) == 0) {
            return true;
        }
        return false;
    }

    private boolean checkRecvNews() {
        if ((q.GL() & 1024) == 0) {
            return true;
        }
        return false;
    }
}
