package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends ag {
    final /* synthetic */ e qzD;

    e$2(e eVar, Looper looper) {
        this.qzD = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        v vVar = (v) message.obj;
        r rVar = new r(vVar.appId, vVar.efG);
        if (this.qzD.qzB.contains(rVar)) {
            this.qzD.qzB.remove(rVar);
            if (!a.bmf().e(vVar.appId, vVar.data, vVar.efG)) {
                x.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
            }
        }
        while (this.qzD.mTQ.size() > 0) {
            r rVar2 = (r) this.qzD.mTQ.remove(0);
            if (this.qzD.a(rVar2)) {
                this.qzD.qzB.add(rVar2);
                return;
            }
        }
    }
}
