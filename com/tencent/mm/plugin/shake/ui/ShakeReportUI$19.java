package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShakeReportUI$19 implements OnClickListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$19(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nbh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
