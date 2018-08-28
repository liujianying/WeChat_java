package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;

class c$12 implements OnClickListener {
    final /* synthetic */ c kJf;

    c$12(c cVar) {
        this.kJf = cVar;
    }

    public final void onClick(View view) {
        c.a(this.kJf, c.aBd(), c.o(this.kJf).kJp, false);
        this.kJf.YC();
        this.kJf.activity.finish();
    }
}
