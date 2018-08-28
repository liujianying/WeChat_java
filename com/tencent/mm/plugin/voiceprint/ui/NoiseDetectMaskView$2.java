package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class NoiseDetectMaskView$2 implements OnClickListener {
    final /* synthetic */ NoiseDetectMaskView oFY;

    NoiseDetectMaskView$2(NoiseDetectMaskView noiseDetectMaskView) {
        this.oFY = noiseDetectMaskView;
    }

    public final void onClick(View view) {
        if (NoiseDetectMaskView.b(this.oFY) != null) {
            NoiseDetectMaskView.b(this.oFY).bJf();
        }
    }
}
