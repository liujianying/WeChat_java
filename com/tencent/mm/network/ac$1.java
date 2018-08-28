package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ac$1 implements a {
    final /* synthetic */ ac etD;

    ac$1(ac acVar) {
        this.etD = acVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[]{Integer.valueOf(ac.b(this.etD).beginBroadcast())});
        for (int i = r0 - 1; i >= 0; i--) {
            try {
                ((n) ac.b(this.etD).getBroadcastItem(i)).ev(ac.c(this.etD));
            } catch (Throwable e) {
                x.e("MicroMsg.NetworkEvent", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        ac.b(this.etD).finishBroadcast();
        return false;
    }
}
