package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.ui.g.a;

class g$6 implements OnClickListener {
    final /* synthetic */ g kwi;

    g$6(g gVar) {
        this.kwi = gVar;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.kwj) {
            aVar.kwj = false;
        } else {
            aVar.kwj = true;
        }
        g.a(this.kwi, (TextView) view);
    }
}
