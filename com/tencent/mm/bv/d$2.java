package com.tencent.mm.bv;

import android.os.Message;
import com.tencent.mm.bv.d.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends ag {
    d$2() {
    }

    public final void handleMessage(Message message) {
        x.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[]{Integer.valueOf(message.what)});
        if (message.what == 0) {
            d.tfC.b((a) message.obj);
        } else if (message.what != 1) {
            d.a(d.tfC, (a) message.obj);
        } else if (d.c(d.tfC) != null) {
            d$b d_b = (d$b) d.c(d.tfC).get();
            if (d_b != null) {
                d_b.cox();
            }
        }
        super.handleMessage(message);
    }
}
