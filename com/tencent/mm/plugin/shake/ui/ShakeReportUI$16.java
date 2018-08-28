package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShakeReportUI$16 implements OnCancelListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$16(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        ShakeReportUI.b(this.nbh, true);
        ShakeReportUI.J(this.nbh);
        ShakeReportUI.K(this.nbh).setText("");
    }
}
