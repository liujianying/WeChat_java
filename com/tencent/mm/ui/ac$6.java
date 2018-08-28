package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class ac$6 implements AnimationListener {
    final /* synthetic */ ac tpr;
    final /* synthetic */ Runnable tpy;

    ac$6(ac acVar, Runnable runnable) {
        this.tpr = acVar;
        this.tpy = runnable;
    }

    public final void onAnimationStart(Animation animation) {
        this.tpr.isAnimating = true;
        au.Em().cii();
        ah.Db(-8);
        this.tpr.v(true, 0);
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.tpr.isAnimating = false;
        this.tpr.tpg.setVisibility(8);
        au.Em().cik();
        ah.Db(0);
        this.tpy.run();
        this.tpr.tryResetChattingSwipeStatus();
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
    }
}
