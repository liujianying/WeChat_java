package com.tencent.mm.ui.appbrand;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ c tro;

    c$3(c cVar) {
        this.tro = cVar;
    }

    public final boolean vD() {
        c cVar = this.tro;
        x.d("MicroMsg.AppBrandServiceImageBubble", "hide");
        if (cVar.qMQ != null) {
            cVar.qMQ.dismiss();
        }
        return false;
    }
}
