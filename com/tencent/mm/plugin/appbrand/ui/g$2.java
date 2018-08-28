package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;

class g$2 implements OnClickListener {
    final /* synthetic */ g gwJ;

    g$2(g gVar) {
        this.gwJ = gVar;
    }

    public final void onClick(View view) {
        e.a(g.f(this.gwJ).mAppId, c.fcf);
        g.f(this.gwJ).finish();
    }
}
