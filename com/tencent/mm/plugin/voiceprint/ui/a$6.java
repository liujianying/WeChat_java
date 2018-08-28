package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.voiceprint.ui.a.a;

class a$6 implements AnimationListener {
    final /* synthetic */ a oGS;

    a$6(a aVar) {
        this.oGS = aVar;
    }

    public final void onAnimationStart(Animation animation) {
        if (this.oGS != null) {
            this.oGS.bJd();
        }
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.oGS != null) {
            this.oGS.bJe();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
