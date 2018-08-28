package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$38 implements AnimationListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$38(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        x.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
        if (SnsCommentDetailUI.B(this.nUO) != null) {
            SnsCommentDetailUI.B(this.nUO).clearAnimation();
            SnsCommentDetailUI.B(this.nUO).setVisibility(8);
        }
    }
}
