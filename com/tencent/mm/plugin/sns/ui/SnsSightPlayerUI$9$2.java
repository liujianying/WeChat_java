package com.tencent.mm.plugin.sns.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9;

class SnsSightPlayerUI$9$2 implements Runnable {
    final /* synthetic */ 9 obf;

    SnsSightPlayerUI$9$2(9 9) {
        this.obf = 9;
    }

    public final void run() {
        if (SnsSightPlayerUI.j(this.obf.obb).getVisibility() != 0) {
            SnsSightPlayerUI.j(this.obf.obb).setVisibility(0);
            SnsSightPlayerUI.j(this.obf.obb).startAnimation(AnimationUtils.loadAnimation(this.obf.obb.mController.tml, a.fast_faded_in));
        }
    }
}
