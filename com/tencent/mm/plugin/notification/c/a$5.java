package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements a {
    final /* synthetic */ a lHC;

    a$5(a aVar) {
        this.lHC = aVar;
    }

    public final boolean vD() {
        if (!this.lHC.lHv) {
            return false;
        }
        x.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.lHC.lHt.lHE.size()), Integer.valueOf(this.lHC.lHw.size()), Integer.valueOf(this.lHC.lHx.size())});
        this.lHC.bkg();
        x.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.lHC.lHt.lHE.size()), Integer.valueOf(this.lHC.lHw.size()), Integer.valueOf(this.lHC.lHx.size())});
        if (this.lHC.lHt.lHE.size() > 0) {
            a.c(this.lHC);
            return true;
        }
        a.d(this.lHC);
        return true;
    }
}
