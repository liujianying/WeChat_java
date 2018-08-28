package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.model.a;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.picker.d.b;

class RemittanceBusiUI$8 implements b {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$8(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void hq(boolean z) {
        if (z) {
            xb xbVar = RemittanceBusiUI.z(this.mBt).myH;
            String str = "MicroMsg.RemittanceBusiUI";
            String str2 = "onFavorSelected %s ";
            Object[] objArr = new Object[1];
            objArr[0] = xbVar == null ? "" : a.a(xbVar);
            x.i(str, str2, objArr);
            RemittanceBusiUI.A(this.mBt);
        }
    }
}
