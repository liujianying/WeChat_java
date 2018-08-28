package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;

public final class b extends a {
    b() {
        super(l.gjv - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (!pVar.fdO.aaq() && pVar.fdO.fcz.gmM) {
            lVar.e(this.gjO, context.getString(j.app_brand_back_to_home));
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        pVar.fdO.fcz.V(pVar.fdO.fcv.adU(), true);
        if (pVar.gns != null) {
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 20, "", bi.VE(), 1, 0);
        }
    }
}
