package com.tencent.mm.ui;

import com.tencent.mm.g.a.sa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class aa$3 extends c<sa> {
    final /* synthetic */ aa toC;

    aa$3(aa aaVar) {
        this.toC = aaVar;
        this.sFo = sa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.v("MicroMsg.LauncherUI.MainTabUnreadMgr", "appTagUnreadChangeListener, event:%s", new Object[]{((sa) bVar).toString()});
        this.toC.cqD();
        return false;
    }
}
