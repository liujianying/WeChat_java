package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.statusbar.d;

class SnsUserUI$3 implements a {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$3(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
    }

    public final void lH(int i) {
        SnsUserUI.l(this.ohd).setPadding(0, i, 0, 0);
        d.a(this.ohd.getWindow());
    }
}
