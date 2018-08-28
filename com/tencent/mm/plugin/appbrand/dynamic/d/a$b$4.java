package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class a$b$4 implements Runnable {
    final /* synthetic */ String fhQ;
    final /* synthetic */ String fvL;
    final /* synthetic */ b fvM;
    final /* synthetic */ a fvP;
    final /* synthetic */ LinkedList fvQ;
    final /* synthetic */ String fvR;

    a$b$4(b bVar, String str, a aVar, LinkedList linkedList, String str2, String str3) {
        this.fvM = bVar;
        this.fvL = str;
        this.fvP = aVar;
        this.fvQ = linkedList;
        this.fhQ = str2;
        this.fvR = str3;
    }

    public final void run() {
        int i = 1;
        IPCDynamicPageView sH = com.tencent.mm.plugin.appbrand.dynamic.h.a.afs().sH(this.fvL);
        if (sH == null) {
            x.e("MicroMsg.IPCInvoke_DoAuthorize", "dynamicPageView not found! widgetid[%s]", this.fvL);
            return;
        }
        com.tencent.mm.plugin.appbrand.dynamic.widget.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.widget.b(sH.getContext());
        1 1 = new 1(this);
        if (this.fvQ == null || this.fvQ.size() <= 0) {
            x.e("MicroMsg.IPCInvoke_DoAuthorize", "scopeInfoList is empty!");
        } else {
            LinkedList linkedList = this.fvQ;
            String str = this.fhQ;
            String str2 = this.fvR;
            x.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
            bVar.mAppName = str;
            bVar.fyq = str2;
            if (bVar.a(linkedList, 1)) {
                i = 0;
            }
        }
        if (i != 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("retCode", -2);
            this.fvP.i(bundle);
        }
    }
}
