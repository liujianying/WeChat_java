package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.d;

class c$a {
    final /* synthetic */ c gzA;
    final int gzu;
    final int gzv;
    private final int gzw;
    final int gzx;
    final int gzy;
    final int gzz;

    /* synthetic */ c$a(c cVar, Context context, byte b) {
        this(cVar, context);
    }

    private c$a(c cVar, Context context) {
        this.gzA = cVar;
        this.gzu = c.c(context, 0.7f);
        this.gzv = (int) (((float) a.fk(context)) / 18.0f);
        this.gzw = 0;
        this.gzx = c.c(context, 3.85f);
        this.gzy = a.g(context, d.app_brand_launcher_recents_list_inset_shadow);
        this.gzz = 2;
    }
}
