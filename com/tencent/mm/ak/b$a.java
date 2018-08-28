package com.tencent.mm.ak;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;

class b$a extends ag {
    private WeakReference<b> dTv;

    public b$a(b bVar, Looper looper) {
        super(looper);
        this.dTv = new WeakReference(bVar);
    }

    public final void handleMessage(Message message) {
        b bVar = (b) this.dTv.get();
        if (bVar != null && 1 == message.what) {
            if (!bVar.dTj && System.currentTimeMillis() - bVar.dTk > 1200000) {
                x.d("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            } else if (bVar.dTh != 0 || bVar.dTg.size() <= 0 || bVar.dTl != 0 || bVar.dTm) {
                x.d("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + bVar.dTh + " size: " + bVar.dTg.size() + " cnt: " + bVar.dTl + " pauseOnMonitor: " + bVar.dTm);
            } else {
                synchronized (bVar.dTg) {
                    bVar.dTh = ((Long) bVar.dTg.pop()).longValue();
                }
                bd dW = ((i) g.l(i.class)).bcY().dW(bVar.dTh);
                e bq = o.Pf().bq(dW.field_msgSvrId);
                if (bq.cGG == 1) {
                    x.d("MicroMsg.AutoGetBigImgLogic", bVar.dTh + " already has hd thumb");
                    bVar.dTh = 0;
                    bVar.start();
                    return;
                }
                x.d("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + bVar.dTh + "  image_" + dW.field_msgId);
                com.tencent.mm.modelcdntran.g.ND().dPa.add("image_" + dW.field_msgId);
                o.Pg().a(bq.dTK, dW.field_msgId, 0, Long.valueOf(bVar.dTh), bVar.dTi, bVar);
            }
        }
    }
}
