package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class IPCallTalkUI$3 implements OnClickListener {
    final /* synthetic */ IPCallTalkUI kzf;

    IPCallTalkUI$3(IPCallTalkUI iPCallTalkUI) {
        this.kzf = iPCallTalkUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kzf.finish();
    }
}
