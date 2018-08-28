package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class SnsCommentDetailUI$39 implements AnimationListener {
    final /* synthetic */ SnsCommentDetailUI nUO;
    boolean nVh = false;
    final /* synthetic */ LinearLayout nVi;

    SnsCommentDetailUI$39(SnsCommentDetailUI snsCommentDetailUI, LinearLayout linearLayout) {
        this.nUO = snsCommentDetailUI;
        this.nVi = linearLayout;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.nVi != null) {
            this.nVi.setPressed(false);
        }
        if (!this.nVh) {
            this.nVh = true;
            if (SnsCommentDetailUI.B(this.nUO) != null) {
                SnsCommentDetailUI.B(this.nUO).clearAnimation();
                SnsCommentDetailUI.B(this.nUO).setVisibility(8);
            }
        }
        SnsCommentDetailUI.D(this.nUO);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
