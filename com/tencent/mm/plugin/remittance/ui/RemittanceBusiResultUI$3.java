package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.f;

class RemittanceBusiResultUI$3 implements Runnable {
    final /* synthetic */ RemittanceBusiResultUI mAr;

    RemittanceBusiResultUI$3(RemittanceBusiResultUI remittanceBusiResultUI) {
        this.mAr = remittanceBusiResultUI;
    }

    public final void run() {
        View findViewById = this.mAr.findViewById(f.bottom_layout);
        if (findViewById != null) {
            int fromDPToPix = a.fromDPToPix(this.mAr, 25);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.topMargin = fromDPToPix;
            marginLayoutParams.bottomMargin = fromDPToPix;
            findViewById.setLayoutParams(marginLayoutParams);
            findViewById.setVisibility(0);
        }
    }
}
