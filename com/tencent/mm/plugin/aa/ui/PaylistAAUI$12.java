package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

class PaylistAAUI$12 implements Runnable {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$12(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final void run() {
        int height = this.eEl.getWindow().getDecorView().getHeight();
        int[] iArr = new int[2];
        View findViewById = this.eEl.findViewById(f.paylist_aa_main_layout);
        findViewById.getLocationInWindow(iArr);
        int height2 = iArr[1] + findViewById.getHeight();
        int fromDPToPix = a.fromDPToPix(this.eEl.mController.tml, 20);
        int fromDPToPix2 = ((height - height2) - a.fromDPToPix(this.eEl.mController.tml, 24)) - a.fromDPToPix(this.eEl.mController.tml, 12);
        if (fromDPToPix2 < fromDPToPix) {
            fromDPToPix2 = fromDPToPix;
        }
        x.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", new Object[]{Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2)});
        LayoutParams layoutParams = (LayoutParams) PaylistAAUI.f(this.eEl).getLayoutParams();
        layoutParams.topMargin = fromDPToPix2;
        PaylistAAUI.f(this.eEl).setLayoutParams(layoutParams);
    }
}
