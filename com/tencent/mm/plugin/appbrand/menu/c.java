package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.tools.k;

final class c extends a {
    c() {
        super(l.gjH - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (bj.cjh()) {
            lVar.a(this.gjO, context.getResources().getColor(d.red_text_color), context.getString(s$j.app_brand_actionsheet_debug_entrance));
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        k kVar2 = new k(context);
        kVar2.ofp = new 1(this, pVar);
        kVar2.ofq = new 2(this, pVar, context);
        kVar2.bEo();
    }
}
