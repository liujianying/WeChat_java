package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VoipCSMainUI$1 implements OnClickListener {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$1(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.oYm.yZ(0);
    }
}
