package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class OfflineAlertView$8 implements Runnable {
    final /* synthetic */ View lKU;
    final /* synthetic */ OfflineAlertView lKX;

    OfflineAlertView$8(OfflineAlertView offlineAlertView, View view) {
        this.lKX = offlineAlertView;
        this.lKU = view;
    }

    public final void run() {
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(this.lKU.getHeight()), Integer.valueOf(this.lKU.getMeasuredHeight())});
        LayoutParams layoutParams = (LayoutParams) OfflineAlertView.a(this.lKX).getLayoutParams();
        if (this.lKU.getHeight() > 0) {
            layoutParams.height = this.lKU.getHeight();
            OfflineAlertView.a(this.lKX).setLayoutParams(layoutParams);
            OfflineAlertView.a(this.lKX).invalidate();
        }
        if (OfflineAlertView.b(this.lKX) != null) {
            OfflineAlertView.b(this.lKX).onShow();
        }
    }
}
