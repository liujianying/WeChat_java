package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$7 implements OnClickListener {
    final /* synthetic */ c fKg;

    c$7(c cVar) {
        this.fKg = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.fKg.fJQ.E(this.fKg.fFd, this.fKg.f("fail", null));
    }
}
