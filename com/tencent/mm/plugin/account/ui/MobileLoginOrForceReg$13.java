package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class MobileLoginOrForceReg$13 implements Runnable {
    final /* synthetic */ MobileLoginOrForceReg eTx;
    final /* synthetic */ String val$url;

    MobileLoginOrForceReg$13(MobileLoginOrForceReg mobileLoginOrForceReg, String str) {
        this.eTx = mobileLoginOrForceReg;
        this.val$url = str;
    }

    public final void run() {
        Object obj = null;
        try {
            obj = c.decodeStream(b.n(this.val$url, 10000, 20000));
        } catch (Throwable e) {
            x.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
            x.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", e, "", new Object[0]);
        }
        MobileLoginOrForceReg.b(this.eTx).sendMessage(MobileLoginOrForceReg.b(this.eTx).obtainMessage(0, obj));
    }

    public final String toString() {
        return super.toString() + "|loadBitmap";
    }
}
