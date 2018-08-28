package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a fDu;

    a$1(a aVar) {
        this.fDu = aVar;
    }

    public final void onClick(View view) {
        if (a.a(this.fDu) != null) {
            a.a(this.fDu).onClick(view);
        }
    }
}
