package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$13 implements OnClickListener {
    final /* synthetic */ c fKg;
    final /* synthetic */ boolean fKq;

    c$13(c cVar, boolean z) {
        this.fKg = cVar;
        this.fKq = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "confirm login");
        dialogInterface.dismiss();
        if (this.fKq) {
            c.a(this.fKg);
            c.b(this.fKg);
            return;
        }
        x.i("MicroMsg.JsApiGetPhoneNumber", "not need to verify sms, and do callback");
        this.fKg.aif();
        h.mEJ.h(14249, new Object[]{this.fKg.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fKg.fKd), Integer.valueOf(this.fKg.fKe), Integer.valueOf(this.fKg.fKc)});
    }
}
