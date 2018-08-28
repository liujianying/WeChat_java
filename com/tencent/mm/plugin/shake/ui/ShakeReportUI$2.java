package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShakeReportUI$2 implements OnClickListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$2(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ShakeReportUI.r(this.nbh) != null) {
            ShakeReportUI.r(this.nbh).cancel();
        }
    }
}
