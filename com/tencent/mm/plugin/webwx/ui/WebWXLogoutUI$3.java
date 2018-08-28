package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class WebWXLogoutUI$3 implements OnClickListener {
    final /* synthetic */ WebWXLogoutUI qmC;
    final /* synthetic */ Animator qmD;

    WebWXLogoutUI$3(WebWXLogoutUI webWXLogoutUI, Animator animator) {
        this.qmC = webWXLogoutUI;
        this.qmD = animator;
    }

    public final void onClick(View view) {
        if (WebWXLogoutUI.c(this.qmC)) {
            WebWXLogoutUI.d(this.qmC).setImageResource(R.k.connect_icon_lock_on_regular);
        } else {
            WebWXLogoutUI.d(this.qmC).setImageResource(R.k.connect_icon_lock_off_regular);
        }
        WebWXLogoutUI.e(this.qmC);
        this.qmC.findViewById(R.h.webwx_lock_progress).setVisibility(0);
        this.qmD.start();
    }
}
