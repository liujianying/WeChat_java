package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class AppUpdaterUI$13 implements OnCancelListener {
    final /* synthetic */ AppUpdaterUI sDx;

    AppUpdaterUI$13(AppUpdaterUI appUpdaterUI) {
        this.sDx = appUpdaterUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.AppUpdaterUI", "click cancel button");
        AppUpdaterUI.a(this.sDx, 12);
        AppUpdaterUI.i(this.sDx);
    }
}
