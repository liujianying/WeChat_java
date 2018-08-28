package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class a$3 implements OnClickListener {
    final /* synthetic */ a gFq;
    final /* synthetic */ OnClickListener val$listener;

    a$3(a aVar, OnClickListener onClickListener) {
        this.gFq = aVar;
        this.val$listener = onClickListener;
    }

    public final void onClick(View view) {
        if (System.currentTimeMillis() - a.e(this.gFq) < 250) {
            this.val$listener.onClick(view);
            a.a(this.gFq, 0);
        }
        a.a(this.gFq, System.currentTimeMillis());
    }
}
