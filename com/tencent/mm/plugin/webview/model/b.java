package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    public volatile ah pQX = new ah("WebviewWorkerThread");
    ak pQY;

    public b(ak akVar) {
        this.pQY = akVar;
    }

    public final ah Em() {
        if (this.pQX == null) {
            this.pQX = new ah("WebviewWorkerThread");
        }
        return this.pQX;
    }
}
