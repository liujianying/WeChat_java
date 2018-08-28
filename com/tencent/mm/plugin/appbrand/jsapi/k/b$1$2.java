package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.k.b.1;

class b$1$2 implements OnCancelListener {
    final /* synthetic */ 1 fXF;

    b$1$2(1 1) {
        this.fXF = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.fXF.fCl.E(this.fXF.doP, this.fXF.fXD.f("cancel", null));
    }
}
