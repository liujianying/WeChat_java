package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;

public abstract class b extends com.tencent.mm.ui.applet.SecurityImage.b {
    SecurityImage eIX = null;
    l ePq = null;

    public abstract l a(l lVar, String str);

    public final void Xe() {
        g.DF().a(a(this.ePq, ""), 0);
    }
}
