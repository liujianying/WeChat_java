package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.widget.c.c.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnCancelListener {
    final /* synthetic */ a gFQ;
    final /* synthetic */ c gFS;

    c$3(c cVar, a aVar) {
        this.gFS = cVar;
        this.gFQ = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        this.gFQ.f(3, null);
    }
}
