package com.tencent.mm.plugin.appbrand.widget;

import android.view.View;
import android.view.View.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ c gEs;

    public c$2(c cVar) {
        this.gEs = cVar;
    }

    public final void onClick(View view) {
        this.gEs.lU(c.b(this.gEs).indexOfChild(view));
        c.c(this.gEs);
    }
}
