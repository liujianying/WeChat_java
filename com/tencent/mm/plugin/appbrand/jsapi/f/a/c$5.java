package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.k;

class c$5 implements OnClickListener {
    final /* synthetic */ c fTi;
    final /* synthetic */ boolean fTl;
    final /* synthetic */ k fTn;
    final /* synthetic */ String fwv;

    c$5(c cVar, boolean z, k kVar, String str) {
        this.fTi = cVar;
        this.fTl = z;
        this.fTn = kVar;
        this.fwv = str;
    }

    public final void onClick(View view) {
        if (this.fTl && this.fTn != null) {
            this.fTn.tE(this.fwv);
        }
    }
}
