package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.FrameLayout.LayoutParams;

class SelfQRCodeUI$1 implements Runnable {
    final /* synthetic */ SelfQRCodeUI mQy;

    SelfQRCodeUI$1(SelfQRCodeUI selfQRCodeUI) {
        this.mQy = selfQRCodeUI;
    }

    public final void run() {
        int width = SelfQRCodeUI.a(this.mQy).getWidth();
        LayoutParams layoutParams = (LayoutParams) SelfQRCodeUI.a(this.mQy).getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        SelfQRCodeUI.a(this.mQy).setLayoutParams(layoutParams);
    }
}
