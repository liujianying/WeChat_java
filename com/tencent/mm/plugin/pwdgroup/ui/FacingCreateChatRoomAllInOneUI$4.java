package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FacingCreateChatRoomAllInOneUI$4 implements AnimationListener {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;

    FacingCreateChatRoomAllInOneUI$4(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.mam = facingCreateChatRoomAllInOneUI;
    }

    public final void onAnimationStart(Animation animation) {
        FacingCreateChatRoomAllInOneUI.k(this.mam).setVisibility(4);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FacingCreateChatRoomAllInOneUI.l(this.mam).setVisibility(8);
        FacingCreateChatRoomAllInOneUI.g(this.mam).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.m(this.mam).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.n(this.mam).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.k(this.mam).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.o(this.mam).setVisibility(8);
        FacingCreateChatRoomAllInOneUI.p(this.mam).setVisibility(8);
        FacingCreateChatRoomAllInOneUI.g(this.mam).clearAnimation();
        FacingCreateChatRoomAllInOneUI.m(this.mam).clearAnimation();
        FacingCreateChatRoomAllInOneUI.k(this.mam).clearAnimation();
    }
}
