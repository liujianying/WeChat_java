package com.tencent.mm.plugin.webwx.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WebWXLogoutUI$1 implements OnClickListener {
    final /* synthetic */ WebWXLogoutUI qmC;

    WebWXLogoutUI$1(WebWXLogoutUI webWXLogoutUI) {
        this.qmC = webWXLogoutUI;
    }

    public final void onClick(View view) {
        WebWXLogoutUI.a(this.qmC, !WebWXLogoutUI.a(this.qmC));
        WebWXLogoutUI.b(this.qmC, WebWXLogoutUI.a(this.qmC));
        WebWXLogoutUI.b(this.qmC);
    }
}
