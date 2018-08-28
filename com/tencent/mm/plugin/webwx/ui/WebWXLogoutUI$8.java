package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.ui.base.h;

class WebWXLogoutUI$8 implements OnClickListener {
    final /* synthetic */ WebWXLogoutUI qmC;

    WebWXLogoutUI$8(WebWXLogoutUI webWXLogoutUI) {
        this.qmC = webWXLogoutUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ac acVar = new ac(1);
        au.DF().a(acVar, 0);
        WebWXLogoutUI webWXLogoutUI = this.qmC;
        ActionBarActivity actionBarActivity = this.qmC.mController.tml;
        this.qmC.getString(R.l.app_tip);
        WebWXLogoutUI.a(webWXLogoutUI, h.a(actionBarActivity, null, true, new 1(this, acVar)));
    }
}
