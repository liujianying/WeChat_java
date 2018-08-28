package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.share.e;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class h extends a {
    h() {
        super(l.gjx - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        boolean z = true;
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (!(appBrandSysConfig == null || context == null)) {
            if ((appBrandSysConfig.aeg() & 64) > 0) {
                com.tencent.mm.plugin.appbrand.ui.a aVar = new com.tencent.mm.plugin.appbrand.ui.a(context);
                aVar.abu(context.getString(j.app_brand_dialog_can_offer_service));
                aVar.mF(false);
                aVar.Gt(j.app_brand_confirm).a(new 1());
                aVar.anj().show();
            } else {
                z = false;
            }
        }
        if (!z) {
            AppBrandSysConfig appBrandSysConfig2 = pVar.fdO.fcu;
            a aVar2 = new a();
            Map hashMap = new HashMap();
            hashMap.put("title", appBrandSysConfig2.bKC);
            hashMap.put("desc", "");
            hashMap.put("path", pVar.gns.getPagePath());
            hashMap.put("imgUrl", appBrandSysConfig2.fqJ);
            aVar2.a(pVar).x(hashMap).ahM();
            e.ajC();
        }
    }
}
