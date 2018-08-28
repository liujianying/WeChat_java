package com.tencent.mm.plugin.account.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnCancelListener {
    final /* synthetic */ c eNV;

    public c$1(c cVar) {
        this.eNV = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.w("MicroMsg.DoInit", "do init canceled");
        g.DF().c(this.eNV.bKq);
        if (this.eNV.bKq.getType() == com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX) {
            g.DF().b(com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX, this.eNV);
        } else if (this.eNV.bKq.getType() == 138) {
            g.DF().b(138, this.eNV);
        }
    }
}
