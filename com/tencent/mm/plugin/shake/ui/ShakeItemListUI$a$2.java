package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class ShakeItemListUI$a$2 implements b {
    final /* synthetic */ a mZD;

    ShakeItemListUI$a$2(a aVar) {
        this.mZD = aVar;
    }

    public final String jd(int i) {
        if (i < 0 || i >= this.mZD.getCount()) {
            x.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
            return null;
        }
        d dVar = (d) this.mZD.getItem(i);
        return dVar == null ? null : dVar.field_username;
    }

    public final int Xy() {
        return this.mZD.getCount();
    }
}
