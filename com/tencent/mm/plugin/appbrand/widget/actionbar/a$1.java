package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a gFq;

    a$1(a aVar) {
        this.gFq = aVar;
    }

    public final void onClick(View view) {
        if (a.a(this.gFq) != null) {
            a.a(this.gFq).onClick(a.b(this.gFq));
        }
    }
}
