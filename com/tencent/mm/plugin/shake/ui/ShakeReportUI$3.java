package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class ShakeReportUI$3 implements OnCancelListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$3(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.HU();
        c.DT().setInt(4118, 1);
        ShakeReportUI.s(this.nbh).setVisibility(8);
    }
}
