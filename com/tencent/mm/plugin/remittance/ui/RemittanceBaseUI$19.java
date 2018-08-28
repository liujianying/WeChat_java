package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.aa.c;
import com.tencent.mm.plugin.wxpay.a.e;

class RemittanceBaseUI$19 implements Runnable {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$19(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final void run() {
        Bitmap a = c.a(this.mzz.cYO, false, -1);
        if (a == null) {
            this.mzz.myW.setImageResource(e.default_avatar);
        } else {
            this.mzz.myW.setImageBitmap(a);
        }
    }
}
