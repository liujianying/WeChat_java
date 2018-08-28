package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.b;

class MySafeDeviceListUI$2 implements OnCancelListener {
    final /* synthetic */ MySafeDeviceListUI eOK;
    final /* synthetic */ b eOL;

    MySafeDeviceListUI$2(MySafeDeviceListUI mySafeDeviceListUI, b bVar) {
        this.eOK = mySafeDeviceListUI;
        this.eOL = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eOL);
    }
}
