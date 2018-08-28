package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b gFu;

    b$1(b bVar) {
        this.gFu = bVar;
    }

    public final void onClick(View view) {
        if (b.a(this.gFu) != null) {
            b.a(this.gFu).onClick(b.b(this.gFu));
        } else if (b.c(this.gFu) != null) {
            b.c(this.gFu).onClick(b.b(this.gFu));
        }
    }
}
