package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;

class AppChooserUI$2 implements OnClickListener {
    final /* synthetic */ AppChooserUI qRB;

    AppChooserUI$2(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (AppChooserUI.c(this.qRB) != null && AppChooserUI.c(this.qRB).qRF != null) {
            g.Ei().DT().set(AppChooserUI.a(this.qRB, 274528), AppChooserUI.c(this.qRB).qRF.activityInfo.packageName);
            AppChooserUI.a(this.qRB, AppChooserUI.c(this.qRB).qRF.activityInfo.packageName, true);
        }
    }
}
