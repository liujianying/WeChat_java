package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.f;

final class RadarTipsView$e extends f implements a<Animation> {
    final /* synthetic */ RadarTipsView mmp;

    RadarTipsView$e(RadarTipsView radarTipsView) {
        this.mmp = radarTipsView;
    }

    public final /* synthetic */ Object invoke() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mmp.getContext(), com.tencent.mm.plugin.radar.a.a.radar_tips_fade_out);
        loadAnimation.setAnimationListener((AnimationListener) new a(this));
        return loadAnimation;
    }
}
