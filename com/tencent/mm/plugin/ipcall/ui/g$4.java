package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.d;

class g$4 implements OnClickListener {
    final /* synthetic */ g kwi;

    g$4(g gVar) {
        this.kwi = gVar;
    }

    public final void onClick(View view) {
        this.kwi.dismiss();
        int i = -1;
        d.a(-1, 1, i, "", 0, -1, -1, g.e(this.kwi), g.f(this.kwi));
    }
}
