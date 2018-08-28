package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsAdNativeLandingTestUI$6 implements OnClickListener {
    final /* synthetic */ SnsAdNativeLandingTestUI nTe;

    SnsAdNativeLandingTestUI$6(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.nTe = snsAdNativeLandingTestUI;
    }

    public final void onClick(View view) {
        if (!"".equals(SnsAdNativeLandingTestUI.a(this.nTe).getVideoPath()) && SnsAdNativeLandingTestUI.a(this.nTe).getVideoPath() != null) {
            if (this.nTe.nTd.getVisibility() == 0) {
                this.nTe.nTd.setVisibility(4);
            } else {
                this.nTe.nTd.setVisibility(0);
            }
        }
    }
}
