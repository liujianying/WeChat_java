package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.f;

final class RadarTipsView$d extends f implements a<Animation> {
    final /* synthetic */ RadarTipsView mmp;

    RadarTipsView$d(RadarTipsView radarTipsView) {
        this.mmp = radarTipsView;
    }

    public final /* synthetic */ Object invoke() {
        return AnimationUtils.loadAnimation(this.mmp.getContext(), com.tencent.mm.plugin.radar.a.a.radar_tips_fade_in);
    }
}
