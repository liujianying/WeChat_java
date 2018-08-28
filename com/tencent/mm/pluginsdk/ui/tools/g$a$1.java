package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.sdk.platformtools.ag;

class g$a$1 extends ag {
    final /* synthetic */ g qSM;
    final /* synthetic */ a qSN;

    g$a$1(a aVar, Looper looper, g gVar) {
        this.qSN = aVar;
        this.qSM = gVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        a aVar = this.qSN;
        Object obj = message.obj;
        if (obj != null && aVar.qSL.size() < aVar.qSK) {
            aVar.qSL.add(obj);
        }
    }
}
