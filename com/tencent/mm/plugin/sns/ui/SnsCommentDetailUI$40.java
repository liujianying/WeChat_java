package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.ui.widget.a;

class SnsCommentDetailUI$40 implements AnimationListener {
    final /* synthetic */ float bCl;
    final /* synthetic */ float bCm;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ View nVj;
    final /* synthetic */ View nVk;
    final /* synthetic */ int nVl;
    final /* synthetic */ int nVm;
    final /* synthetic */ View oI;

    SnsCommentDetailUI$40(SnsCommentDetailUI snsCommentDetailUI, View view, View view2, int i, View view3, int i2, float f, float f2) {
        this.nUO = snsCommentDetailUI;
        this.nVj = view;
        this.nVk = view2;
        this.nVl = i;
        this.oI = view3;
        this.nVm = i2;
        this.bCl = f;
        this.bCm = f2;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.nVj.setVisibility(0);
        this.nVk.setVisibility(8);
        SnsCommentDetailUI.b(this.nUO, this.nVl);
        a aVar = new a(this.oI.getContext(), (float) this.nVm, 0.0f, this.bCl, this.bCm, false);
        aVar.setDuration(187);
        aVar.setInterpolator(new DecelerateInterpolator());
        aVar.setFillAfter(true);
        this.oI.startAnimation(aVar);
    }
}
