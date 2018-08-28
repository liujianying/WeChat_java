package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class FindMContactAlertUI$10 implements OnCancelListener {
    final /* synthetic */ FindMContactAlertUI eHH;

    FindMContactAlertUI$10(FindMContactAlertUI findMContactAlertUI) {
        this.eHH = findMContactAlertUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FindMContactAlertUI.h(this.eHH) != null) {
            g.DF().b(431, FindMContactAlertUI.h(this.eHH));
            FindMContactAlertUI.i(this.eHH);
            FindMContactAlertUI.j(this.eHH);
        }
    }
}
