package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarStateChooseView.b;

public final class RadarStateChooseView$b$a implements AnimationListener {
    final /* synthetic */ b mlH;

    RadarStateChooseView$b$a(b bVar) {
        this.mlH = bVar;
    }

    public final void onAnimationStart(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationEnd(Animation animation) {
        e.i(animation, "animation");
        RadarStateChooseView.a(this.mlH.mlG);
        this.mlH.mlG.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
        e.i(animation, "animation");
    }
}
