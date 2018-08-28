package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VoipCSMainUI$6 implements OnClickListener {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$6(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oYm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
