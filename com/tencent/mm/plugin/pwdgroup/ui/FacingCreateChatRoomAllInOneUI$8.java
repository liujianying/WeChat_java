package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FacingCreateChatRoomAllInOneUI$8 implements AnimationListener {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;
    final /* synthetic */ Animation mao;

    FacingCreateChatRoomAllInOneUI$8(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI, Animation animation) {
        this.mam = facingCreateChatRoomAllInOneUI;
        this.mao = animation;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FacingCreateChatRoomAllInOneUI.g(this.mam).aPm();
        FacingCreateChatRoomAllInOneUI.g(this.mam).startAnimation(this.mao);
    }
}
