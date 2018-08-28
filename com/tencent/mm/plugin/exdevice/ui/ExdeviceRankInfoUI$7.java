package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ExdeviceRankInfoUI$7 implements OnCancelListener {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$7(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (ExdeviceRankInfoUI.e(this.iFG) != null) {
            ExdeviceRankInfoUI.e(this.iFG).dismiss();
            ExdeviceRankInfoUI.f(this.iFG);
        }
        this.iFG.finish();
    }
}
