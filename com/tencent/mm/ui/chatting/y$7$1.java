package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.y.7;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.g;

class y$7$1 implements Runnable {
    final /* synthetic */ 7 tMn;

    y$7$1(7 7) {
        this.tMn = 7;
    }

    public final void run() {
        this.tMn.tMm.cpO();
        if (this.tMn.tMm.isCurrentActivity || !this.tMn.tMm.isSupportNavigationSwipeBack()) {
            this.tMn.tMm.cuf();
            return;
        }
        SwipeBackLayout swipeBackLayout = this.tMn.tMm.getSwipeBackLayout();
        x.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[]{Boolean.valueOf(swipeBackLayout.uIg), Boolean.valueOf(swipeBackLayout.uIe), Boolean.valueOf(swipeBackLayout.uIf)});
        if (!swipeBackLayout.cAF()) {
            g.aD(0.0f);
            swipeBackLayout.uIg = true;
            swipeBackLayout.uIf = false;
            int width = (swipeBackLayout.FU.getWidth() + swipeBackLayout.uIb.getIntrinsicWidth()) + 10;
            a aVar = swipeBackLayout.uHZ;
            aVar.CI = swipeBackLayout.FU;
            aVar.cF = -1;
            aVar.g(width, 0, 0, 0);
            swipeBackLayout.invalidate();
            if (swipeBackLayout.uIk != null) {
                swipeBackLayout.uIk.onDrag();
            }
            g.A(true, 0);
        }
    }
}
