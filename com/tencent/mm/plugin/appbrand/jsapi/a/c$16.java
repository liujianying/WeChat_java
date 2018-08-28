package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$16 implements OnClickListener {
    final /* synthetic */ c fKg;

    c$16(c cVar) {
        this.fKg = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to bind phone number");
        dialogInterface.dismiss();
        this.fKg.fJQ.E(this.fKg.fFd, this.fKg.f("fail:cancel to bind phone", null));
        h.mEJ.h(14249, new Object[]{this.fKg.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fKg.fKd), Integer.valueOf(this.fKg.fKe), Integer.valueOf(this.fKg.fKc)});
    }
}
