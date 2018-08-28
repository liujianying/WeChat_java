package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.conversation.g.b;

class j$1 implements b {
    final /* synthetic */ j ure;

    j$1(j jVar) {
        this.ure = jVar;
    }

    public final void cyR() {
        j.a(this.ure).clearCache();
        au.HU();
        c.FW().a(j.a(this.ure));
        au.HU();
        c.FR().a(j.a(this.ure));
    }
}
