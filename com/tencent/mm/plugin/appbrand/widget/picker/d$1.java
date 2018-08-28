package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class d$1 implements OnClickListener {
    final /* synthetic */ d gNm;

    d$1(d dVar) {
        this.gNm = dVar;
    }

    public final void onClick(View view) {
        d.a(this.gNm, true, d.c(this.gNm) == null ? null : d.c(this.gNm).aqq());
    }
}
