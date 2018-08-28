package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$27 implements AnimationListener {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$27(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
    }

    public final void onAnimationRepeat(Animation animation) {
        x.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
    }
}
