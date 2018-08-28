package com.tencent.mm.plugin.topstory.ui.video;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryVideoViewControlBar.a;

class n$16 implements a {
    final /* synthetic */ n oBM;

    n$16(n nVar) {
        this.oBM = nVar;
    }

    public final void update(int i, int i2) {
        int width;
        if (i2 > 0) {
            width = (n.n(this.oBM).getWidth() * i) / i2;
        } else {
            width = 0;
        }
        com.tencent.mm.plugin.topstory.a.b.a aVar = n.b(this.oBM).bHU().oAm;
        if (aVar != null && aVar.oyT < ((long) n.b(this.oBM).bHS().getCurrPosMs())) {
            aVar.oyT = (long) n.b(this.oBM).bHS().getCurrPosMs();
        }
        LayoutParams layoutParams = (LayoutParams) n.o(this.oBM).getLayoutParams();
        layoutParams.width = width;
        n.o(this.oBM).setLayoutParams(layoutParams);
        n.o(this.oBM).requestLayout();
    }

    public final void bIx() {
        n.p(this.oBM).setVisibility(8);
    }

    public final void bIy() {
        if (n.b(this.oBM).bHS().oCg && (n.b(this.oBM).bHS().bIB() || n.b(this.oBM).bHS().oCh)) {
            n.p(this.oBM).setVisibility(0);
        } else {
            n.p(this.oBM).setVisibility(8);
        }
    }
}
