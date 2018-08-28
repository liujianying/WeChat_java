package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import b.c.b.e;
import b.c.b.f;

final class RadarStateView$b extends f implements b.c.a.a<Animation> {
    final /* synthetic */ RadarStateView mlN;

    public static final class a implements AnimationListener {
        final /* synthetic */ RadarStateView$b mlO;

        a(RadarStateView$b radarStateView$b) {
            this.mlO = radarStateView$b;
        }

        public final void onAnimationStart(Animation animation) {
            e.i(animation, "animation");
        }

        public final void onAnimationEnd(Animation animation) {
            e.i(animation, "animation");
            RadarStateView.b(this.mlO.mlN);
            this.mlO.mlN.setVisibility(8);
        }

        public final void onAnimationRepeat(Animation animation) {
            e.i(animation, "animation");
        }
    }

    RadarStateView$b(RadarStateView radarStateView) {
        this.mlN = radarStateView;
    }

    public final /* synthetic */ Object invoke() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mlN.getContext(), com.tencent.mm.plugin.radar.a.a.radar_state_slide_in);
        loadAnimation.setAnimationListener(new a(this));
        return loadAnimation;
    }
}
