package com.tencent.mm.plugin.remittance.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;

class RemittanceBusiResultUI$2 implements Runnable {
    final /* synthetic */ RemittanceBusiResultUI mAr;
    final /* synthetic */ ImageView mAs;

    RemittanceBusiResultUI$2(RemittanceBusiResultUI remittanceBusiResultUI, ImageView imageView) {
        this.mAr = remittanceBusiResultUI;
        this.mAs = imageView;
    }

    public final void run() {
        ViewGroup viewGroup = (ViewGroup) this.mAr.findViewById(f.scrollview_layout);
        LayoutParams layoutParams = this.mAs.getLayoutParams();
        layoutParams.width = viewGroup.getWidth();
        layoutParams.height = viewGroup.getHeight();
        this.mAs.setLayoutParams(layoutParams);
    }
}
