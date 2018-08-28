package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class av$7 implements AnimationListener {
    boolean nVh = false;
    final /* synthetic */ LinearLayout nVi;
    final /* synthetic */ av ocj;
    final /* synthetic */ Runnable ocl;

    av$7(av avVar, LinearLayout linearLayout, Runnable runnable) {
        this.ocj = avVar;
        this.nVi = linearLayout;
        this.ocl = runnable;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.nVi != null) {
            this.nVi.setPressed(false);
        }
        if (!this.nVh) {
            this.nVh = true;
            if ((this.ocj.bGc instanceof u) && ((u) this.ocj.bGc).bCa()) {
                this.ocj.obU.notifyDataSetChanged();
            }
        }
        if (this.ocl != null) {
            this.ocl.run();
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
