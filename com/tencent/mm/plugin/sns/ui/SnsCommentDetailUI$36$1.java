package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.36;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.39;

class SnsCommentDetailUI$36$1 implements Runnable {
    final /* synthetic */ View gvo;
    final /* synthetic */ 36 nVc;

    SnsCommentDetailUI$36$1(36 36, View view) {
        this.nVc = 36;
        this.gvo = view;
    }

    public final void run() {
        SnsCommentDetailUI snsCommentDetailUI = this.nVc.nUO;
        LinearLayout linearLayout = (LinearLayout) this.gvo;
        ImageView imageView = (ImageView) linearLayout.findViewById(f.album_like_icon);
        Animation scaleAnimation = new ScaleAnimation(0.9f, 1.5f, 0.9f, 1.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setStartOffset(100);
        scaleAnimation.setRepeatCount(0);
        imageView.clearAnimation();
        imageView.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new 39(snsCommentDetailUI, linearLayout));
        SnsCommentDetailUI.v(this.nVc.nUO);
    }
}
