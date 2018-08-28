package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class WebWXLogoutUI$2 extends AnimatorListenerAdapter {
    final /* synthetic */ WebWXLogoutUI qmC;

    WebWXLogoutUI$2(WebWXLogoutUI webWXLogoutUI) {
        this.qmC = webWXLogoutUI;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        WebWXLogoutUI.c(this.qmC, WebWXLogoutUI.c(this.qmC));
    }
}
