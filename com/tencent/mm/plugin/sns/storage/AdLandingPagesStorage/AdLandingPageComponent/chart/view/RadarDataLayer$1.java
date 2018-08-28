package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.Map.Entry;

class RadarDataLayer$1 implements AnimatorUpdateListener {
    final /* synthetic */ RadarDataLayer nCJ;

    RadarDataLayer$1(RadarDataLayer radarDataLayer) {
        this.nCJ = radarDataLayer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (Entry entry : RadarDataLayer.a(this.nCJ).entrySet()) {
            RadarDataLayer.b(this.nCJ).put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * floatValue));
            this.nCJ.invalidate();
        }
    }
}
