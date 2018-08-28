package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShakeReportUI$23 implements OnClickListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$23(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ShakeReportUI.N(this.nbh);
        this.nbh.finish();
    }
}
