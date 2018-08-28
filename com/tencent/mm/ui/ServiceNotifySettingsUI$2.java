package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ServiceNotifySettingsUI$2 implements OnCancelListener {
    final /* synthetic */ ServiceNotifySettingsUI tqb;

    ServiceNotifySettingsUI$2(ServiceNotifySettingsUI serviceNotifySettingsUI) {
        this.tqb = serviceNotifySettingsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tqb.finish();
    }
}
