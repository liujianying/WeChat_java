package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class MobileLoginOrForceReg$1 extends ag {
    final /* synthetic */ MobileLoginOrForceReg eTx;

    MobileLoginOrForceReg$1(MobileLoginOrForceReg mobileLoginOrForceReg) {
        this.eTx = mobileLoginOrForceReg;
    }

    public final void handleMessage(Message message) {
        if (message.obj != null) {
            MobileLoginOrForceReg.a(this.eTx).setImageBitmap((Bitmap) message.obj);
        }
    }
}
