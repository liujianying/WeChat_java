package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class IPCallDialUI$4 implements OnClickListener {
    final /* synthetic */ IPCallDialUI kvy;

    IPCallDialUI$4(IPCallDialUI iPCallDialUI) {
        this.kvy = iPCallDialUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kvy.finish();
    }
}
