package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.voiceprint.ui.a.a;

class a$3 implements AnimationListener {
    final /* synthetic */ a oGS;

    a$3(a aVar) {
        this.oGS = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.oGS != null) {
            this.oGS.bJe();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
