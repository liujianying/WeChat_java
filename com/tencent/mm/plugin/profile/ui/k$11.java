package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.x;

class k$11 implements a {
    final /* synthetic */ k lWx;

    k$11(k kVar) {
        this.lWx = kVar;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.lWx.hMQ, Boolean.valueOf(z)});
        this.lWx.lWw.dead();
    }
}
