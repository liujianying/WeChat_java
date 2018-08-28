package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class NearbyFriendsUI$b$2 implements b {
    final /* synthetic */ NearbyFriendsUI.b lCj;

    NearbyFriendsUI$b$2(NearbyFriendsUI.b bVar) {
        this.lCj = bVar;
    }

    public final String jd(int i) {
        if (i < 0 || i >= this.lCj.getCount()) {
            x.e("MicroMsg.NearbyFriend", "pos is invalid");
            return null;
        }
        aqp tQ = this.lCj.tQ(i);
        if (tQ != null) {
            return tQ.hbL;
        }
        return null;
    }

    public final int Xy() {
        return this.lCj.getCount();
    }
}
