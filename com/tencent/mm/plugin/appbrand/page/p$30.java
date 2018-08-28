package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;

class p$30 implements OnClickListener {
    final /* synthetic */ p gnH;

    p$30(p pVar) {
        this.gnH = pVar;
    }

    public final void onClick(View view) {
        a alS = this.gnH.alS();
        if (alS == null || !alS.akm()) {
            this.gnH.fdO.fcz.agJ();
        }
    }
}
