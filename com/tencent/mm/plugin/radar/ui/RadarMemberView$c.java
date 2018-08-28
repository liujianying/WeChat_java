package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarMemberView.d;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarMemberView$c implements AnimationListener {
    final /* synthetic */ RadarMemberView mlg;

    RadarMemberView$c(RadarMemberView radarMemberView) {
        this.mlg = radarMemberView;
    }

    public final void onAnimationStart(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationRepeat(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationEnd(Animation animation) {
        e.i(animation, "animation");
        RadarMemberView$a radarMemberView$a = RadarMemberView.mlf;
        x.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
        RadarMemberView.e(this.mlg);
        d d = RadarMemberView.d(this.mlg);
        RadarMemberView$a radarMemberView$a2 = RadarMemberView.mlf;
        d.sendEmptyMessage(RadarMemberView.bpA());
    }
}
