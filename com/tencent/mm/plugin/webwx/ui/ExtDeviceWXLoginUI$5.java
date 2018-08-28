package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webwx.a.e;

class ExtDeviceWXLoginUI$5 implements OnCancelListener {
    final /* synthetic */ ExtDeviceWXLoginUI qmq;
    final /* synthetic */ e qmr;

    ExtDeviceWXLoginUI$5(ExtDeviceWXLoginUI extDeviceWXLoginUI, e eVar) {
        this.qmq = extDeviceWXLoginUI;
        this.qmr = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.qmr);
        if (ExtDeviceWXLoginUI.e(this.qmq) != null) {
            ExtDeviceWXLoginUI.e(this.qmq).cancel();
        }
    }
}
