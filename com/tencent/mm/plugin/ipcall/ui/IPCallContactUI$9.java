package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class IPCallContactUI$9 implements OnCancelListener {
    final /* synthetic */ IPCallContactUI kuK;

    IPCallContactUI$9(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.kuK.finish();
    }
}
