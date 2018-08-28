package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.ui.base.l;

public final class e extends a {
    public e() {
        super(l.gjA - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (appBrandSysConfig.frm.fih == 1) {
            CharSequence string;
            if (appBrandSysConfig.fqM) {
                string = context.getString(s$j.app_brand_performance_disable);
            } else {
                string = context.getString(s$j.app_brand_performance_enable);
            }
            lVar.e(l.gjA - 1, string);
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        if ((!pVar.fdO.fcu.fqM ? 1 : 0) != 0) {
            AppBrandPerformanceManager.vg(str);
            Toast.makeText(context, s$j.app_brand_performance_enable_toast, 0).show();
            return;
        }
        AppBrandPerformanceManager.vh(str);
        Toast.makeText(context, s$j.app_brand_performance_disable_toast, 0).show();
    }
}
