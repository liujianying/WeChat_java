package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.10;
import com.tencent.mm.ui.tools.f.b;

class SnsOnlineVideoActivity$10$1 implements b {
    final /* synthetic */ 10 nZn;

    SnsOnlineVideoActivity$10$1(10 10) {
        this.nZn = 10;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        if (SnsOnlineVideoActivity.c(this.nZn.nZl) != null) {
            SnsOnlineVideoActivity.c(this.nZn.nZl).onResume();
        }
    }
}
