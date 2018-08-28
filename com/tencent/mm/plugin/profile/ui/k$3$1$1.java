package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.ui.k.3.1;
import com.tencent.mm.sdk.platformtools.x;

class k$3$1$1 implements a {
    final /* synthetic */ String lWA;
    final /* synthetic */ 1 lWB;

    k$3$1$1(1 1, String str) {
        this.lWB = 1;
        this.lWA = str;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.lWB.lWz.lWx.hMQ, Boolean.valueOf(z)});
        if (z) {
            au.HU();
            this.lWB.lWz.lWx.ee(this.lWA, c.FR().Yg(str).BK());
        }
    }
}
