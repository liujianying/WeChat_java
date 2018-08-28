package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.b;

class MMGridPaper$5 implements b {
    final /* synthetic */ MMGridPaper tvg;

    MMGridPaper$5(MMGridPaper mMGridPaper) {
        this.tvg = mMGridPaper;
    }

    public final void vC(int i) {
        x.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.tvg.tuM), Integer.valueOf(this.tvg.tuN), Integer.valueOf(this.tvg.tuO)});
        if (i <= this.tvg.tuM && this.tvg.tuM > 0) {
            this.tvg.msM.post(new 1(this, i));
        } else if (i >= this.tvg.tuN && this.tvg.tuN < this.tvg.tuO - 1) {
            this.tvg.msM.post(new 2(this, i));
        }
        this.tvg.tuK = i;
        this.tvg.gKU.setSelectedDot(i);
    }
}
