package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class HighlightRectSideView$1 implements a {
    final /* synthetic */ HighlightRectSideView mIv;

    HighlightRectSideView$1(HighlightRectSideView highlightRectSideView) {
        this.mIv = highlightRectSideView;
    }

    public final boolean vD() {
        HighlightRectSideView.a(this.mIv);
        this.mIv.invalidate();
        return true;
    }
}
