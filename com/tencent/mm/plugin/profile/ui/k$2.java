package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements a {
    final /* synthetic */ k lWx;

    k$2(k kVar) {
        this.lWx = kVar;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.lWx.hMQ, Boolean.valueOf(z)});
        if (z) {
            au.HU();
            this.lWx.ee(this.lWx.bHY, c.FR().Yg(str).BK());
        }
    }
}
