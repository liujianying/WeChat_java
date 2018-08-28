package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;
import java.util.Map;

public final class g extends a {
    public g() {
        super(l.gjw - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (appBrandSysConfig == null || appBrandSysConfig.frm.fih != 0 || (appBrandSysConfig.aeg() & 32) <= 0) {
            lVar.e(this.gjO, context.getString(j.app_brand_share));
        }
    }

    public final void a(Context context, final p pVar, final String str, final k kVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(context, "pref_appbrand_" + appBrandSysConfig.uin, 4);
        if (appBrandSysConfig.frm.fih == 1 && !sharedPreferences.contains("has_share_dev_tips")) {
            sharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
            h.a(context, j.app_brand_first_time_share_dev_page_tips, j.app_tip, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.a(pVar, kVar);
                }
            });
        } else if (appBrandSysConfig.frm.fih != 2 || sharedPreferences.contains("has_share_beta_tips")) {
            a(pVar, kVar);
        } else {
            sharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
            h.a(context, j.app_brand_first_time_share_beta_page_tips, j.app_tip, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.a(pVar, kVar);
                }
            });
        }
    }

    static void a(p pVar, k kVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        a aVar = new a();
        Map hashMap = new HashMap();
        hashMap.put("title", appBrandSysConfig.bKC);
        hashMap.put("desc", "");
        hashMap.put("path", pVar.ahc());
        String str = "webViewUrl";
        com.tencent.mm.plugin.appbrand.jsapi.p.a alS = pVar.alS();
        hashMap.put(str, alS != null ? alS.getWebView().getUrl() : null);
        hashMap.put("imgUrl", appBrandSysConfig.fqJ);
        hashMap.put("mode", kVar.fvX.ie("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(kVar.fvX.ie("enable_share_dynamic")));
        kVar.fvX.w("user_clicked_share_btn", true);
        aVar.a(pVar).x(hashMap).ahM();
    }
}
