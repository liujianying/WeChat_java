package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements OnCancelListener {
    final /* synthetic */ b$a fyv;
    final /* synthetic */ b fyx;

    b$4(b bVar, b$a b_a) {
        this.fyx = bVar;
        this.fyv = b_a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        this.fyv.f(3, null);
    }
}
