package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.tools.f.b;

class SnsOnlineVideoActivity$11 implements b {
    final /* synthetic */ SnsOnlineVideoActivity nZl;

    SnsOnlineVideoActivity$11(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.nZl = snsOnlineVideoActivity;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new ag().post(new 1(this));
    }
}
