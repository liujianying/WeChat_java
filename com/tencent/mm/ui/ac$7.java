package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class ac$7 implements Runnable {
    final /* synthetic */ ac tpr;

    ac$7(ac acVar) {
        this.tpr = acVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        au.Em().cik();
        ah.Db(0);
        this.tpr.nfG.onSwipe(1.0f);
        if (this.tpr.tpg != null) {
            this.tpr.tpg.czV();
        }
        this.tpr.tpo.cpN();
        this.tpr.tryResetChattingSwipeStatus();
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final String toString() {
        return super.toString() + "|chattingView_onAnimationEnd";
    }
}
