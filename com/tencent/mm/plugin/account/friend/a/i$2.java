package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class i$2 implements b {
    final /* synthetic */ i eKi;

    i$2(i iVar) {
        this.eKi = iVar;
    }

    public final String jd(int i) {
        if (i < 0 || i >= this.eKi.getCount()) {
            x.e("MicroMsg.FriendAdapter", "pos is invalid");
            return null;
        }
        arf jc = this.eKi.jc(i);
        if (jc != null) {
            return jc.hbL;
        }
        return null;
    }

    public final int Xy() {
        return this.eKi.getCount();
    }
}
