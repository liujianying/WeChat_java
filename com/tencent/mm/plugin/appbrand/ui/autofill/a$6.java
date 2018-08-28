package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class a$6 implements OnClickListener {
    final /* synthetic */ a gxq;
    final /* synthetic */ bnm gxr;

    a$6(a aVar, bnm bnm) {
        this.gxq = aVar;
        this.gxr = bnm;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
        if (a.a(this.gxq) != null) {
            a.a(this.gxq).vH(((ei) this.gxr.slD.get(0)).url);
        }
    }
}
