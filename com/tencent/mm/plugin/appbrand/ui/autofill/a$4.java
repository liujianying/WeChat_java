package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bnm;

class a$4 implements OnClickListener {
    final /* synthetic */ a gxq;
    final /* synthetic */ bnm gxr;

    a$4(a aVar, bnm bnm) {
        this.gxq = aVar;
        this.gxr = bnm;
    }

    public final void onClick(View view) {
        if (a.a(this.gxq) != null) {
            a.a(this.gxq).vG(this.gxr.slC.url);
        }
    }
}
