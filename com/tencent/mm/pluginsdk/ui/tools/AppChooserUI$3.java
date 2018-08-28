package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AppChooserUI$3 implements OnClickListener {
    final /* synthetic */ AppChooserUI qRB;

    AppChooserUI$3(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (AppChooserUI.c(this.qRB) != null && AppChooserUI.c(this.qRB).qRF != null) {
            AppChooserUI.a(this.qRB, AppChooserUI.c(this.qRB).qRF.activityInfo.packageName, false);
        }
    }
}
