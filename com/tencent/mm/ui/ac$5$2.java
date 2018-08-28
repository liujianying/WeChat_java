package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ac.5;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;

class ac$5$2 implements a {
    final /* synthetic */ 5 tpx;

    ac$5$2(5 5) {
        this.tpx = 5;
    }

    public final void cqP() {
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
        this.tpx.start = System.currentTimeMillis();
        if (this.tpx.tpr.tpn.getSwipeBackLayout() != null) {
            this.tpx.tpr.tpn.getSwipeBackLayout().startAnimation(this.tpx.tpr.mChattingInAnim);
        } else {
            this.tpx.tpr.tpn.getView().startAnimation(this.tpx.tpr.mChattingInAnim);
        }
        this.tpx.tpr.tpg.setOndispatchDraw(null);
    }
}
