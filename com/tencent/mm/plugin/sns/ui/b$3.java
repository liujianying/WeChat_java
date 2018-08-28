package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.sns.ui.b.b;

class b$3 implements AnimationListener {
    final /* synthetic */ b nKk;
    final /* synthetic */ b nKl;

    b$3(b bVar, b bVar2) {
        this.nKl = bVar;
        this.nKk = bVar2;
    }

    public final void onAnimationStart(Animation animation) {
        if (this.nKk != null) {
            this.nKk.onAnimationStart();
        }
        this.nKl.nKj = this.nKl.nKi;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.nKk != null) {
            this.nKk.onAnimationEnd();
        }
        this.nKl.nKj = this.nKl.nKf;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
