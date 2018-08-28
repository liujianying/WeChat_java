package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$8 implements a {
    final /* synthetic */ long bAw;
    final /* synthetic */ a lHC;

    a$8(a aVar, long j) {
        this.lHC = aVar;
        this.bAw = j;
    }

    public final boolean vD() {
        if (!(this.lHC.lHw.contains(Long.valueOf(this.bAw)) || this.lHC.lHx.contains(Long.valueOf(this.bAw)) || !this.lHC.lHt.ek(this.bAw))) {
            x.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", new Object[]{Long.valueOf(this.bAw)});
            this.lHC.lHx.add(Long.valueOf(this.bAw));
            this.lHC.lHy.add(Long.valueOf(this.bAw));
            if (this.lHC.lHw.size() + this.lHC.lHx.size() >= this.lHC.lHt.lHE.size()) {
                a.d(this.lHC);
            } else {
                this.lHC.eg(this.lHC.lHt.bks());
            }
        }
        return true;
    }
}
