package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridPaper.5;

class MMGridPaper$5$1 implements Runnable {
    final /* synthetic */ int tvh;
    final /* synthetic */ 5 tvi;

    MMGridPaper$5$1(5 5, int i) {
        this.tvi = 5;
        this.tvh = i;
    }

    public final void run() {
        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.tvi.tvg.tuF.getChildAt(this.tvi.tvg.tuF.getChildCount() - 1);
        x.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[]{Integer.valueOf(this.tvi.tvg.tuF.getChildCount() - 1), Integer.valueOf(this.tvh - (this.tvi.tvg.tuF.getChildCount() >> 1))});
        this.tvi.tvg.tuF.removeViewAt(this.tvi.tvg.tuF.getChildCount() - 1);
        mMGridPaperGridView.a(r1, this.tvi.tvg.hQu, this.tvi.tvg.mNumColumns, this.tvi.tvg.tuG);
        this.tvi.tvg.tuF.addView(mMGridPaperGridView, 0);
        this.tvi.tvg.tuF.El(this.tvi.tvg.tuF.getChildCount() >> 1);
        MMGridPaper.a(this.tvi.tvg, -1);
    }
}
