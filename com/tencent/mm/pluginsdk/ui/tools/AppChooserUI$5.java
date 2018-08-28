package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AppChooserUI$5 implements OnDismissListener {
    final /* synthetic */ AppChooserUI qRB;

    AppChooserUI$5(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.qRB.finish();
    }
}
