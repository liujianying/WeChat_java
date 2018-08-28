package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;

class d$2 extends z {
    final /* synthetic */ d gfB;

    d$2(d dVar, String str, int i, String str2, int i2, d dVar2) {
        this.gfB = dVar;
        super(str, i, str2, i2, dVar2);
    }

    public final void akC() {
        d.a(this.gfB);
    }

    public final void akE() {
        d.b(this.gfB);
    }

    public final void onDownloadProgress(int i) {
        if (this.gfB.gfu != null) {
            this.gfB.gfu.onDownloadProgress(i);
        }
    }
}
