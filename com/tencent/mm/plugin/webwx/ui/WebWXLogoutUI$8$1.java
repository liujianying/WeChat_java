package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.8;

class WebWXLogoutUI$8$1 implements OnCancelListener {
    final /* synthetic */ ac mRd;
    final /* synthetic */ 8 qmE;

    WebWXLogoutUI$8$1(8 8, ac acVar) {
        this.qmE = 8;
        this.mRd = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mRd);
        if (WebWXLogoutUI.i(this.qmE.qmC) != null) {
            WebWXLogoutUI.i(this.qmE.qmC).cancel();
        }
    }
}
