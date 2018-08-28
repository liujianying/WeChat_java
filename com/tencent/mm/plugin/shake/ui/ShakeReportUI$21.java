package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShakeReportUI$21 implements OnClickListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$21(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nbh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        ShakeReportUI.N(this.nbh);
        this.nbh.finish();
    }
}
