package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements AnimationListener {
    final /* synthetic */ a iQo;
    final /* synthetic */ a$b iQq;

    a$2(a aVar, a$b a_b) {
        this.iQo = aVar;
        this.iQq = a_b;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
