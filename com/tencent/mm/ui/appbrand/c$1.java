package com.tencent.mm.ui.appbrand;

import android.view.View;
import android.view.View.OnClickListener;

class c$1 implements OnClickListener {
    final /* synthetic */ c tro;

    c$1(c cVar) {
        this.tro = cVar;
    }

    public final void onClick(View view) {
        if (this.tro.trm != null) {
            this.tro.trm.cra();
        }
        this.tro.qMQ.dismiss();
    }
}
