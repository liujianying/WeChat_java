package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.mm.plugin.cdndownloader.d.b;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements b {
    final /* synthetic */ a hKi;

    a$1(a aVar) {
        this.hKi = aVar;
    }

    public final void aAm() {
        x.i("MicroMsg.CDNDownloadClient", "notify add");
        this.hKi.aAg();
        a aVar = this.hKi;
        x.i("MicroMsg.CDNDownloadClient", "startCheckProcessActiveTimer");
        aVar.hKf.J(20000, 20000);
    }

    public final void remove() {
        x.i("MicroMsg.CDNDownloadClient", "notify remove");
        if (this.hKi.hKc.size() == 0) {
            a.a(this.hKi);
            a.b(this.hKi);
        }
    }

    public final void clear() {
        x.i("MicroMsg.CDNDownloadClient", "notify clear");
        a.a(this.hKi);
        a.b(this.hKi);
    }
}
