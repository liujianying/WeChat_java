package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements OnClickListener {
    final /* synthetic */ b dKr;
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ f fKA;
    final /* synthetic */ ed fKw;

    f$3(f fVar, ed edVar, p pVar, int i, b bVar) {
        this.fKA = fVar;
        this.fKw = edVar;
        this.fJO = pVar;
        this.doP = i;
        this.dKr = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
        this.fKw.reK = true;
        this.fJO.E(this.doP, this.fKA.f("ok", null));
        com.tencent.mm.ipcinvoker.wx_extension.b.a(this.dKr, new 1(this));
    }
}
