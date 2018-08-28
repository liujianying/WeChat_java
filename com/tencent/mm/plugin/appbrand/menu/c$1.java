package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class c$1 implements c {
    final /* synthetic */ p fIY;
    final /* synthetic */ c gjl;

    c$1(c cVar, p pVar) {
        this.gjl = cVar;
        this.fIY = pVar;
    }

    public final void a(l lVar) {
        lVar.eR(1, j.app_brand_actionsheet_debug_entrance_silent_restart);
        lVar.eR(2, j.app_brand_actionsheet_debug_entrance_nfs_path);
        lVar.e(3, "appID: " + this.fIY.mAppId);
        lVar.e(4, "TRIM PAGE");
    }
}
