package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;

class g$3 implements OnClickListener {
    final /* synthetic */ g qqw;

    g$3(g gVar) {
        this.qqw = gVar;
    }

    public final void onClick(View view) {
        this.qqw.qqu.dismiss();
        this.qqw.mParentView.setVisibility(8);
        if (this.qqw.qqv != null) {
            this.qqw.qqv.bZV();
        }
    }
}
