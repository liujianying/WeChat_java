package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ a gFq;

    a$2(a aVar) {
        this.gFq = aVar;
    }

    public final void onClick(View view) {
        if (a.c(this.gFq) != null) {
            a.c(this.gFq).onClick(a.d(this.gFq));
        } else if (a.a(this.gFq) != null) {
            a.a(this.gFq).onClick(a.d(this.gFq));
        }
    }
}
