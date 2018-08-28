package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import b.c.a.a;
import b.c.b.e;
import b.c.b.f;

final class RadarStateChooseView$c extends f implements a<Animation> {
    final /* synthetic */ RadarStateChooseView mlG;

    RadarStateChooseView$c(RadarStateChooseView radarStateChooseView) {
        this.mlG = radarStateChooseView;
    }

    public final /* synthetic */ Object invoke() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mlG.getContext(), com.tencent.mm.plugin.radar.a.a.radar_state_sacle_out);
        loadAnimation.setAnimationListener((AnimationListener) new a());
        e.h(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
        return loadAnimation;
    }
}
