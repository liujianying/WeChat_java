package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import com.tencent.mm.ui.MMActivity;

class SnsAdNativeLandingTestUI$7 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingTestUI nTe;

    SnsAdNativeLandingTestUI$7(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.nTe = snsAdNativeLandingTestUI;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.nTe.mController.tml instanceof MMActivity) {
            ((MMActivity) this.nTe.mController.tml).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            SnsAdNativeLandingTestUI.a(this.nTe).setDrawableWidth(displayMetrics.widthPixels);
        }
        SnsAdNativeLandingTestUI.a(this.nTe).requestLayout();
        SnsAdNativeLandingTestUI.a(this.nTe).postInvalidate();
    }
}
