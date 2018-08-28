package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class NoiseDetectMaskView$1 implements OnClickListener {
    final /* synthetic */ NoiseDetectMaskView oFY;

    NoiseDetectMaskView$1(NoiseDetectMaskView noiseDetectMaskView) {
        this.oFY = noiseDetectMaskView;
    }

    public final void onClick(View view) {
        if (NoiseDetectMaskView.a(this.oFY) != null) {
            NoiseDetectMaskView.a(this.oFY).bJg();
        }
    }
}
