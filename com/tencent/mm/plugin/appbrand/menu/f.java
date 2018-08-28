package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;

public final class f extends a {
    public f() {
        super(l.gjC - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (b.chp()) {
            lVar.a(this.gjO, context.getResources().getColor(s$d.red_text_color), context.getString(j.app_brand_back));
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        e.a(str, c.fcf);
        if (context instanceof Activity) {
            ((Activity) context).finish();
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 10, "", bi.VE(), 1, 0);
        }
    }
}
