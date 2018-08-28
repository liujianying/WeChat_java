package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;

class MMGridPaper$4 implements a {
    final /* synthetic */ MMGridPaper tvg;

    MMGridPaper$4(MMGridPaper mMGridPaper) {
        this.tvg = mMGridPaper;
    }

    public final void dp(int i, int i2) {
        x.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.tvg.tuH), Integer.valueOf(i2), Integer.valueOf(this.tvg.tuI), Boolean.valueOf(this.tvg.tuW), Boolean.valueOf(this.tvg.tuV)});
        if ((Math.abs(this.tvg.tuI - i2) < 50 && Math.abs(this.tvg.tuH - i) < 50) || i2 == 0 || i == 0) {
            x.d("MicroMsg.MMGridPaper", "match width height limit, return");
        } else if (!this.tvg.tuW || this.tvg.tuH <= i || this.tvg.tuV) {
            x.v("MicroMsg.MMGridPaper", "onMeasure: match");
            x.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[]{Boolean.valueOf(this.tvg.tvc)});
            this.tvg.tuV = false;
            if (!this.tvg.tvc) {
                this.tvg.tuI = i2;
                this.tvg.tuH = i;
            }
            this.tvg.refresh();
        } else {
            x.d("MicroMsg.MMGridPaper", "match ori limit, return");
        }
    }
}
