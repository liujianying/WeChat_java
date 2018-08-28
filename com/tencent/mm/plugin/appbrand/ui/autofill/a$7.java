package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.ei;

class a$7 implements OnClickListener {
    final /* synthetic */ a gxq;
    final /* synthetic */ bnm gxr;

    a$7(a aVar, bnm bnm) {
        this.gxq = aVar;
        this.gxr = bnm;
    }

    public final void onClick(View view) {
        if (a.a(this.gxq) != null) {
            a.a(this.gxq).vI(((ei) this.gxr.slD.get(1)).url);
        }
    }
}
