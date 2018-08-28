package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements OnClickListener {
    final /* synthetic */ a gxq;

    a$3(a aVar) {
        this.gxq = aVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
        if (a.a(this.gxq) != null) {
            a.a(this.gxq).anJ();
        }
    }
}
