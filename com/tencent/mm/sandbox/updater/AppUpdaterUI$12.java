package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;

class AppUpdaterUI$12 implements OnClickListener {
    final /* synthetic */ c sDA;
    final /* synthetic */ AppUpdaterUI sDx;

    AppUpdaterUI$12(AppUpdaterUI appUpdaterUI, c cVar) {
        this.sDx = appUpdaterUI;
        this.sDA = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppUpdaterUI", "click download button");
        AppUpdaterUI.a(this.sDx, 11);
        if (this.sDA != null) {
            this.sDA.deleteTempFile();
        }
        j e = AppUpdaterUI.e(this.sDx);
        e.sEH = true;
        e.chh();
    }
}
