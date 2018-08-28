package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;

class ThrowBottleAnimUI$4 extends ag {
    final /* synthetic */ ThrowBottleAnimUI hnb;

    ThrowBottleAnimUI$4(ThrowBottleAnimUI throwBottleAnimUI) {
        this.hnb = throwBottleAnimUI;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (ThrowBottleAnimUI.i(this.hnb) == null && ThrowBottleAnimUI.a(this.hnb) != null) {
            ThrowBottleAnimUI.a(this.hnb, (SprayLayout) ThrowBottleAnimUI.a(this.hnb).findViewById(R.h.bottle_spray_fl));
        }
        if (ThrowBottleAnimUI.i(this.hnb) != null) {
            ThrowBottleAnimUI.i(this.hnb).stop();
        }
        if (ThrowBottleAnimUI.m(this.hnb) != null) {
            ThrowBottleAnimUI.m(this.hnb).auA();
        }
    }
}
