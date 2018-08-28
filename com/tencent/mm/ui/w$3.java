package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.mm.plugin.y.d;
import com.tencent.mm.pluginsdk.model.app.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class w$3 implements Runnable {
    final /* synthetic */ String fRy;
    final /* synthetic */ int tny;
    final /* synthetic */ Context val$context;

    w$3(int i, String str, Context context) {
        this.tny = i;
        this.fRy = str;
        this.val$context = context;
    }

    public final void run() {
        if (this.tny == 4 && a.cbF() == null) {
            x.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
        } else if (d.bfB() != null && d.bfB().Hw(this.fRy) != null) {
            ah.A(new Runnable() {
                public final void run() {
                    if (d.bfB() != null) {
                        d.bfB().dT(w$3.this.val$context);
                    }
                }
            });
        }
    }
}
