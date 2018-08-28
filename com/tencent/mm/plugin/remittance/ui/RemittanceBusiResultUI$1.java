package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;

class RemittanceBusiResultUI$1 implements OnClickListener {
    final /* synthetic */ RemittanceBusiResultUI mAr;

    RemittanceBusiResultUI$1(RemittanceBusiResultUI remittanceBusiResultUI) {
        this.mAr = remittanceBusiResultUI;
    }

    public final void onClick(View view) {
        this.mAr.finish();
    }
}
