package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements a {
    final /* synthetic */ g icw;

    g$2(g gVar) {
        this.icw = gVar;
    }

    public final boolean vD() {
        g.Em().H(new g$3(this.icw));
        g gVar = this.icw;
        boolean z = gVar.icu == null || gVar.icu.size() == 0;
        if (z) {
            x.d("MicroMsg.FileDownloaderImpl23", "timer stop");
        } else {
            this.icw.eOf.J(1000, 1000);
        }
        return false;
    }
}
