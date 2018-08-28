package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;

class p$32 implements OnClickListener {
    final /* synthetic */ p gnH;

    p$32(p pVar) {
        this.gnH = pVar;
    }

    public final void onClick(View view) {
        t tVar = this.gnH.gns;
        tVar.getView().scrollTo(tVar.getView().getScrollX(), 0);
        j.aJ(this.gnH.mAppId, this.gnH.hashCode());
    }
}
