package com.tencent.mm.permission;

import com.tencent.mm.g.a.jm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<jm> {
    final /* synthetic */ b evd;

    b$3(b bVar) {
        this.evd = bVar;
        this.sFo = jm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.PermissionMgr", "show mute dlg");
        PermissionWarningDialog.bV(ad.getContext());
        return false;
    }
}
