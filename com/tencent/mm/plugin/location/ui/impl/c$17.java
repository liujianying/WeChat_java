package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.a;

class c$17 implements a {
    final /* synthetic */ c kJf;

    c$17(c cVar) {
        this.kJf = cVar;
    }

    public final void bae() {
        x.d("MicroMsg.MMPoiMapUI", "back pressed");
        c.a(this.kJf, c.bab(), c.v(this.kJf).kJp, true);
        c.a(this.kJf, null);
    }
}
