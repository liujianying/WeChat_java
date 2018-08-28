package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;

class d$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ d gjn;
    final /* synthetic */ Context val$context;

    d$1(d dVar, String str, Context context) {
        this.gjn = dVar;
        this.bAj = str;
        this.val$context = context;
    }

    public final void run() {
        final boolean vl = a.vl(this.bAj);
        c.runOnUiThread(new Runnable() {
            public final void run() {
                Toast.makeText(d$1.this.val$context, vl ? j.app_brand_performance_dump_trace_success : j.app_brand_performance_dump_trace_fail, 0).show();
            }
        });
    }
}
