package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;

class j$2 implements OnClickListener {
    final /* synthetic */ j hGo;

    j$2(j jVar) {
        this.hGo = jVar;
    }

    public final void onClick(View view) {
        if (this.hGo.eZB != null && this.hGo.eZB.isShowing()) {
            this.hGo.eZB.dismiss();
        }
    }
}
