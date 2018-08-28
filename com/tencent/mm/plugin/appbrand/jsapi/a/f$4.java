package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements OnClickListener {
    final /* synthetic */ b dKr;
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ f fKA;
    final /* synthetic */ ed fKw;

    f$4(f fVar, ed edVar, p pVar, int i, b bVar) {
        this.fKA = fVar;
        this.fKw = edVar;
        this.fJO = pVar;
        this.doP = i;
        this.dKr = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
        this.fKw.reK = false;
        this.fJO.E(this.doP, this.fKA.f("cancel", null));
        com.tencent.mm.ipcinvoker.wx_extension.b.a(this.dKr, new b$a() {
            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
                    x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                    return;
                }
                x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
            }
        });
    }
}
