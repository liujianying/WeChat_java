package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;

class c$3 implements b {
    final /* synthetic */ c kJf;

    c$3(c cVar) {
        this.kJf = cVar;
    }

    public final void bac() {
    }

    public final void FW(String str) {
        x.d("MicroMsg.MMPoiMapUI", "searchText: %s", new Object[]{str});
        c.a(this.kJf, str);
        c.w(this.kJf).crD();
        c.y(this.kJf).setVisibility(8);
        if (bi.oW(str)) {
            c.v(this.kJf).clean();
            c.v(this.kJf).notifyDataSetChanged();
            return;
        }
        c.z(this.kJf);
    }

    public final void WY() {
        x.d("MicroMsg.MMPoiMapUI", "clear btn click");
        c.v(this.kJf).clean();
        c.v(this.kJf).notifyDataSetChanged();
    }

    public final void bad() {
    }
}
