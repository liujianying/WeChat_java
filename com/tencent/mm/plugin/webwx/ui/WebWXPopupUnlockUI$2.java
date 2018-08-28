package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class WebWXPopupUnlockUI$2 implements OnDismissListener {
    final /* synthetic */ WebWXPopupUnlockUI qmF;

    WebWXPopupUnlockUI$2(WebWXPopupUnlockUI webWXPopupUnlockUI) {
        this.qmF = webWXPopupUnlockUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.qmF.finish();
    }
}
