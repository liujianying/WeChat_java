package com.tencent.mm.plugin.appbrand.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.i.a.d;
import com.tencent.mm.plugin.appbrand.i.b.2;

class b$2$1 implements OnCancelListener {
    final /* synthetic */ 2 gkv;

    b$2$1(2 2) {
        this.gkv = 2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        b.a(this.gkv.gkt, this.gkv.fdZ, d.gkk);
    }
}
