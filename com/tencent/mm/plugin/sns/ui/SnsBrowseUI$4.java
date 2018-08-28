package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.f.b;

class SnsBrowseUI$4 implements b {
    final /* synthetic */ SnsBrowseUI nTH;

    SnsBrowseUI$4(SnsBrowseUI snsBrowseUI) {
        this.nTH = snsBrowseUI;
    }

    public final void onAnimationStart() {
        SnsInfoFlip snsInfoFlip = this.nTH.nTu;
        if (snsInfoFlip.nWM != null) {
            snsInfoFlip.nWM.setVisibility(8);
        }
        SnsBrowseUI.e(this.nTH).postDelayed(new Runnable() {
            public final void run() {
                SnsInfoFlip snsInfoFlip = SnsBrowseUI$4.this.nTH.nTu;
                if (snsInfoFlip.nWz != null) {
                    View selectedView = snsInfoFlip.nWz.getSelectedView();
                    if (selectedView instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) selectedView).crm();
                    }
                }
            }
        }, 20);
    }

    public final void onAnimationEnd() {
        SnsBrowseUI.e(this.nTH).post(new 2(this));
    }
}
