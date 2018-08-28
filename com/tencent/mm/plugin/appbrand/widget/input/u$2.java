package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;

class u$2 implements OnClickListener {
    final /* synthetic */ u gIs;

    u$2(u uVar) {
        this.gIs = uVar;
    }

    public final void onClick(View view) {
        if (view.isSelected()) {
            u.apJ().m(this.gIs);
            view.setSelected(false);
            return;
        }
        u.apJ().n(this.gIs);
        view.setSelected(true);
    }
}
