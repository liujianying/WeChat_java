package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class EnterpriseBizContactPlainListUI$a$3 implements b {
    final /* synthetic */ a hpI;

    EnterpriseBizContactPlainListUI$a$3(a aVar) {
        this.hpI = aVar;
    }

    public final String jd(int i) {
        if (i < 0 || i >= this.hpI.getCount()) {
            x.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
            return null;
        }
        ix ixVar = (ix) this.hpI.getItem(i);
        return ixVar == null ? null : ixVar.userName;
    }

    public final int Xy() {
        return this.hpI.getCount();
    }
}
