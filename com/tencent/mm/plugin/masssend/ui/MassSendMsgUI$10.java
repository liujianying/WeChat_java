package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MassSendMsgUI$10 implements OnClickListener {
    final /* synthetic */ MassSendMsgUI lbm;

    MassSendMsgUI$10(MassSendMsgUI massSendMsgUI) {
        this.lbm = massSendMsgUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lbm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
