package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;

public final class j extends a {
    public j() {
        super(l.gjD - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        g.l(d.class);
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        String str2 = appBrandSysConfig.appId;
        int i = appBrandSysConfig.frm.fih;
        AppBrandStickyBannerLogic.a.anT();
        e.a(str, c.fci);
        AppBrandStickyBannerLogic.a.a(context, appBrandSysConfig.appId, appBrandSysConfig.frm.fih, appBrandSysConfig.bKC, appBrandSysConfig.fqJ);
        com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 13, "", bi.VE(), 1, 0);
    }
}
