package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class MMSightCircularProgressBar$1 implements a {
    final /* synthetic */ MMSightCircularProgressBar loj;

    MMSightCircularProgressBar$1(MMSightCircularProgressBar mMSightCircularProgressBar) {
        this.loj = mMSightCircularProgressBar;
    }

    public final void an(float f) {
        MMSightCircularProgressBar.a(this.loj, f);
        this.loj.invalidate();
    }

    public final void onAnimationEnd() {
        x.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
        ah.A(new 1(this));
    }
}
