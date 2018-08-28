package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.ui.base.l;

public final class d extends a {
    public d() {
        super(l.gjI - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (AppBrandPerformanceManager.vi(str)) {
            lVar.e(l.gjI - 1, context.getString(s$j.app_brand_performance_dump_trace));
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        Toast.makeText(context, s$j.app_brand_performance_dump_trace_start, 0).show();
        c.Em().H(new 1(this, str, context));
    }
}
