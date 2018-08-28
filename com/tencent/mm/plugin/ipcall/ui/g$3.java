package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class g$3 implements OnClickListener {
    final /* synthetic */ g kwi;

    g$3(g gVar) {
        this.kwi = gVar;
    }

    public final void onClick(View view) {
        if (view == g.b(this.kwi)) {
            g.a(this.kwi, 1);
        } else if (view == g.c(this.kwi)) {
            g.a(this.kwi, 2);
        } else if (view == g.d(this.kwi)) {
            g.a(this.kwi, 3);
        }
    }
}
