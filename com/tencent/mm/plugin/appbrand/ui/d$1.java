package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;

class d$1 implements OnClickListener {
    final /* synthetic */ d guW;

    d$1(d dVar) {
        this.guW = dVar;
    }

    public final void onClick(View view) {
        e.a(d.a(this.guW).mAppId, c.fcf);
        d.a(this.guW).finish();
    }
}
