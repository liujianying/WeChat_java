package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$a;

class n$5 implements WebSearchWebVideoViewControlBar$a {
    final /* synthetic */ n oBM;

    n$5(n nVar) {
        this.oBM = nVar;
    }

    public final int ajH() {
        o bHS = n.b(this.oBM).bHS();
        return bHS.oCd != null ? bHS.oCd.getCacheTimeSec() : 0;
    }

    public final int ajI() {
        return n.b(this.oBM).bHS().getVideoDurationSec();
    }

    public final int bIw() {
        return n.b(this.oBM).bHS().getCurrPosMs();
    }
}
