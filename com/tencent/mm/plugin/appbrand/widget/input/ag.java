package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.sdk.platformtools.ad;

final class ag extends c {
    private static final int gJy = ad.getContext().getResources().getDimensionPixelSize(e.NormalTextSize);
    private com.tencent.mm.br.e gJx = null;

    ag() {
    }

    protected final com.tencent.mm.br.e apU() {
        if (this.gJx == null) {
            this.gJx = new a();
        }
        return this.gJx;
    }
}
