package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.sdk.platformtools.x;

class WebWXPopupUnlockUI$1 implements OnClickListener {
    final /* synthetic */ Dialog kdj;
    final /* synthetic */ WebWXPopupUnlockUI qmF;

    WebWXPopupUnlockUI$1(WebWXPopupUnlockUI webWXPopupUnlockUI, Dialog dialog) {
        this.qmF = webWXPopupUnlockUI;
        this.kdj = dialog;
    }

    public final void onClick(View view) {
        au.DF().a(new b(2), 0);
        x.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
        a.ezo.eu(1);
        x.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
        this.kdj.dismiss();
    }
}
