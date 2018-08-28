package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.model.app.g.a;

class g$d implements a {
    volatile boolean bSi;
    volatile boolean dJP;
    volatile boolean fGh;
    volatile boolean fGi;
    a qkg;

    g$d(a aVar) {
        this.qkg = aVar;
    }

    public final void cI(boolean z) {
        this.dJP = true;
        this.fGh = z;
        if (this.fGi && this.qkg != null) {
            this.qkg.r(this.bSi, z);
        }
    }

    final void cJ(boolean z) {
        this.bSi = z;
        this.fGi = true;
        if (this.dJP && this.qkg != null) {
            this.qkg.r(z, this.fGh);
        }
    }
}
