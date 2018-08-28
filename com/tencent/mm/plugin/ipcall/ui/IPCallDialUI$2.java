package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.g.a.sb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class IPCallDialUI$2 extends c<sb> {
    final /* synthetic */ IPCallDialUI kvy;

    IPCallDialUI$2(IPCallDialUI iPCallDialUI) {
        this.kvy = iPCallDialUI;
        this.sFo = sb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sb sbVar = (sb) bVar;
        if (sbVar instanceof sb) {
            String str = sbVar.ccS.countryCode;
            if (!(IPCallDialUI.a(this.kvy) == null || bi.oW(str))) {
                IPCallDialUI.a(this.kvy).EW(str);
            }
        }
        return false;
    }
}
